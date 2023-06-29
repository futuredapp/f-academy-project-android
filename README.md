# Futured Dev Academy (Android)

![minSdk](https://img.shields.io/badge/minSdk-21-brightgreen.svg?style=flat) ![targetSdk](https://img.shields.io/badge/targetSdk-33-brightgreen.svg?style=flat)


Miniproject used to learn basics of Android development. Contains basic setup of project, Jetpack Compose, MVVM architecture, REST API etc.

Made by [Futured](https://futured.app). 

## Project info

- Deadline: ~~**--. --. ----**~~
- ApplicationId: `app.futured.academyproject.`
- Supports: **Dark mode, landscape orientation**
- Design: ~~Figma/Zeplin (add link)~~
- Backend: [Mapový portál města Brna](https://gis.brno.cz)
  - ~~Prod: https://live.app.com~~
  - ~~Staging: https://staging.app.com~~
- Interactors: Kotlin Coroutines
- Product Flavors: mock, dev, prod
- Build Variants: debug, enterprise, release
- ~~Localizations: Czech, English – POEditor (add link)~~
- [Architecture decision records](doc/adrs.md)

### Team:

- ~~Jana Nováková, PM, <jana.novakova@futured.app>~~
- ~~Jan Novák, iOS developer, <jan.novak@futured.app>~~
- ~~John Newman, tester, <john.newman@futured.app>~~

### Used Tools

- Code style - **[ktlint](https://ktlint.github.io/)**, **[detekt](https://arturbosch.github.io/detekt/)**, **[Android lint](http://tools.android.com/tips/lint)**, **[Danger](https://github.com/futuredapp/danger)**

### ~~Test accounts~~

- ~~dev - login: `a@a.com`, password: `hesloheslo`~~

### Security standard

This project complies with ~~Standard (F0), High (F1), Highest (F2)~~ security standard.

### Additional Scripts

1. `clean` - remove all `build` folders
2. `lintCheck` - run `ktlint`, `detekt` and `android lint` checks. Same runs on CI.
3. `dependencyUpdates` - check if never version of used dependencies are available
