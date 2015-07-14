MVP Github Client
==================
A demo Android app to use the MVP pattern.

The main intentions of this app is to trial the MVP pattern to verify its effectiveness at increasing
 Android app testability.

Although the app is very simple, I have tried to model it in the style of a production app by
including many libraries and techniques that are arguably over-engineered for a demo app, but would be
more commonplace in larger scale apps. Hopefully, this makes the app more useful as a demonstration
of general best practices.

Abotu Thread Boundaries
-----------------------
In the current implementation the Presenter and the View operate entirely on the main thread.
The Interactor is responsible for supplying data to the Presenter on the main Android thread.

This may require some rework, as it pushes Android dependencies into the Interactor, hence UserModelInteractorImpl
 has two constructors to providing explicit Scheduling control for testing purposes. This is not ideal,
 as I would prefer only the View implementations to have Android dependencies.

I imagine that the optimal solution will be found once the app becomes more complex.

Testing
-------

Testing is done using both "Unit Tests" and "Android Instrumentation Tests". These tests are executed
using a variety of testing libraries, depending on the needs of the test.

Libraries include:
* Mockito - for general mocking behavior
* PowerMock - an extension of Mockito used for more advanced mocking, such as statics, in this case to no-op the AndroidPrecondition checks.
* Dexmaker - for on-device mocking of classes. It generates dexed classes at runtime.

The Unit Tests are generally run with MockitoJUnitRunner. Its usage is optional as its main function
is to initialize the mocked class fields, something that be done directly via MockitoAnnotations.initMocks(Object).

In cases where PowerMock is used, those tests are run with PowerMockRunner. Additionally, initialization
 of static mocks needs to be performed manually.

For Android Instrumentation Tests,

Presenter and Model tests should be Unit Tests, as they should not contain Android dependencies. View and
Interactor dependencies can be mocked/stubbed and injected.

View tests will typically be Android Instrumentation tests, as they will have real Android dependencies,
such as the View hierarchy. They run with the new AndroidJUnit4 runner with an abstract parent class with
a workaround for a long standing known issue with Dexmaker. Note that the ProfileViewImplTest is not a child of
AndroidTestCase. We now have JUnit4 style Android device tests!

Interactor tests, these are a mixture between Android Instrumentation tests and Unit Tests.

AssertJ is used for test verification. It has a nice fluent API, that mostly goes unused in this simple app.

TODO Espresso

List of references
------------------

In no particular order, here's some of the pages I referred to when building this.

MVP
---
http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/
http://antonioleiva.com/mvp-android/
https://github.com/antoniolg/androidmvp
https://github.com/pedrovgs/EffectiveAndroidUI/
https://github.com/LiveTyping/u2020-mvp
http://blog.bradcampbell.nz/mvp-presenters-that-survive-configuration-changes-part-2/
http://www.slideshare.net/ChristianPanadero/my-way-to-clean-android-v2
http://mattlogan.me/decoupling-the-presenter

Testing
------
https://code.google.com/p/android-test-kit/wiki/AndroidJUnitRunnerUserGuide
http://www.mdswanson.com/blog/2014/02/24/integration-testing-rest-apis-for-android.html
https://github.com/commonsguy/cw-omnibus/tree/master/Testing/JUnit4
https://code.google.com/p/powermock/
https://github.com/crittercism/dexmaker
https://github.com/mockito/mockito

Other
-----
http://fernandocejas.com/2015/04/11/tasting-dagger-2-on-android/
https://gist.github.com/JakeWharton/0d67d01badcee0ae7bc9

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