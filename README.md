MVP Github Client
==================
A demo Android app written using the MVP pattern.

The main intentions of this app is to trial the MVP pattern to verify its effectiveness at increasing
 Android app testability.

Although the app is very simple, I have written its structure like that of a production app by
including techniques that are arguably over-engineered for a demo app, but would be
more commonplace in larger scale apps. Hopefully, this makes the app more useful as a demonstration
of general best practices.

##MVP

The MVP pattern I have used is arranged as follows:

* ```Presenter``` - retrieves ```ViewModel``` content via ```Interactor``` and supplies it to ```ViewContract```.
* ```ViewContract``` - manipulates Android ```View``` to display ```ViewModel``` content.
* ```Interactor``` - retrieves specific ```ViewModel``` content from data ```Provider```.
* ```ViewModel``` - mapped model data, typically specific to a ```ViewContract```.

##Testing

Testing is done using both "Unit Tests" and "Android Instrumentation Tests". These tests are executed
using a variety of testing libraries, depending on the needs of the test. These include:

* Mockito - for general mocking behavior
* PowerMock - an extension of Mockito used for more advanced mocking, such as statics, in this case to no-op the ```AndroidPrecondition``` checks.
* Dexmaker - for on-device mocking of classes in instrumentation tests. It generates dexed classes at runtime.

The Unit Tests are generally run via ```@RunWith(MockitoJUnitRunner.class)```. Its usage is optional as its main function
is to initialize the mocked class fields, something that be done directly via ```MockitoAnnotations.initMocks(Object)```.

In cases where PowerMock is required, those tests are run via ```@RunWith(PowerMockRunner.class)```. Additional initialization
 of static mocks is performed manually.

The Android Instrumentation Tests are generally run via the new ```@RunWith(AndroidJUnit4.class)```. If the test
 uses mocking (via Mockito with Dexmaker) they subclass an abstract parent class ```PatchedDexmakerTestCase.java``` that has
a workaround for a long standing known Dexmaker issue. Importantly there's no need to subclass ```AndroidTestCase``` anymore.

Note: PowerMock does not work together with DexMaker according to this source http://stackoverflow.com/a/27956309/937783, there's an
issue (without any activity) that reports that: https://github.com/crittercism/dexmaker/issues/3.

Presenter and Model tests should be Unit Tests, as they should not contain Android dependencies. View and
Interactor dependencies can be mocked/stubbed and injected.

View tests will typically be Android Instrumentation tests, as they will have real Android dependencies,
such as the View hierarchy.

Interactor tests, these are unfortunately a mixture between Unit Tests and Android Instrumentation tests.
 The latter is only required to test that result is delivered on the Android main thread. I'm still
 searching for a good way to test this without having an Android dependency.

 Additionally, to check for correct threading, the Presenter also checks that the Interactor delivers
 values on the Android main thread. This is another Android dependency that I would like to abstract,
 although the check is useful.

AssertJ is used for test verification points. It has a nice fluent API, although that mostly goes unused in this simple app.

TODO Some of the test classes (the asserts) might be better in a standalone Java module.
TODO The fluent asserts for RxJava Observables is worthy of its own project.
TODO Espresso

##About Thread Boundaries
In the current implementation the Presenter and the View operate entirely on the main thread.
The Interactor is responsible for supplying data to the Presenter on the main Android thread.

##List of references
In no particular order, here's some of the pages I referred to when building this.

###MVP
* http://hannesdorfmann.com/android/mosby/
* http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/
* http://antonioleiva.com/mvp-android/
* https://github.com/antoniolg/androidmvp
* https://github.com/pedrovgs/EffectiveAndroidUI/
* https://github.com/LiveTyping/u2020-mvp
* http://blog.bradcampbell.nz/mvp-presenters-that-survive-configuration-changes-part-2/
* http://www.slideshare.net/ChristianPanadero/my-way-to-clean-android-v2
* http://mattlogan.me/decoupling-the-presenter
* https://corner.squareup.com/2014/01/mortar-and-flow.html

###Testing
* https://code.google.com/p/android-test-kit/wiki/AndroidJUnitRunnerUserGuide
* http://www.mdswanson.com/blog/2014/02/24/integration-testing-rest-apis-for-android.html
* https://github.com/commonsguy/cw-omnibus/tree/master/Testing/JUnit4
* https://code.google.com/p/powermock/
* https://github.com/crittercism/dexmaker
* https://github.com/mockito/mockito

###Other
* http://fernandocejas.com/2015/04/11/tasting-dagger-2-on-android/
* https://gist.github.com/JakeWharton/0d67d01badcee0ae7bc9

License
-------

    Copyright 2015 Peter Tackage

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.