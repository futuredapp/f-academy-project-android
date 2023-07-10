# Futured Dev Academy (Android)

![minSdk](https://img.shields.io/badge/minSdk-21-brightgreen.svg?style=flat) ![targetSdk](https://img.shields.io/badge/targetSdk-33-brightgreen.svg?style=flat)

Welcome to the Futured Dev Academy! 

The mini-project is to be used to learn the fundamentals of Android development in FDA. Contains the basic setup of the project, Jetpack Compose, MVVM architecture, REST API, etc. 

Prepared by [Futured](https://futured.app) ♥️

### Futured Team:

- Michaela Kormošová, Head of Coordination, <michaela.kormosova@futured.app>
- David Kočnar, Android dev, <david.kocnar@futured.app>

### Future Graduate:
- ~~Jan Novak, <jan.novak@notsofutured.app>~~


---


## Project info

- Deadline: **12. 9. 2023**
- ApplicationId: `app.futured.academyproject`
- Supports: **Dark mode, landscape orientation**
- Design: ~~Figma/Zeplin (add link)~~
- Backend: [Mapový portál města Brna](https://gis.brno.cz)
- Product Flavors: mock, dev, prod
- Build Variants: debug, enterprise, release
- Localizations: Czech

### Used tech

- Interactors: Kotlin Coroutines + [Arkitekt UseCases](https://github.com/futuredapp/arkitekt)
- CI: GitHub Actions
- UI: [Jetpack Compose](https://developer.android.com/jetpack/compose)
- Architecture: [MVVM](https://developer.android.com/jetpack/guide)
- Dependency Injection: [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- Networking: [Retrofit](https://square.github.io/retrofit/)
- Code style: [ktlint](https://ktlint.github.io/), [detekt](https://github.com/detekt/detekt/), [Android lint](http://tools.android.com/tips/lint), [Danger](https://github.com/futuredapp/danger) 

### Additional Scripts

1. `clean` - remove all `build` folders
2. `lintCheck` - run `ktlint`, `detekt` and `android lint` checks. Same runs on CI.
3. `dependencyUpdates` - check if never version of used dependencies are available
