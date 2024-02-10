# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased] - yyyy-mm-dd

## [0.5.1] - 2024-02-10

### Fixed

- Fix build error when using Fabric on iOS.

## [0.5.0] - 2023-10-25

### Fixed

- Fabric support on React Native 0.71+. This is a breaking change for fabric on 0.70 and lower, however paper/old arch is unaffected.

## [0.4.0] - 2022-07-15

### Added

- Fabric implementation.

### Fixed

- Removed redundant cast causing "BitmapDrawable cannot be cast to VectorDrawable".

## [0.3.0] - 2021-05-21

### Changed

- Default `resizeMode` to `cover` for `Image` compatibility.

## [0.2.1] - 2021-05-21

### Changed

- Move `resizeMode` to style props for `Image` compatibility.

## [0.2.0] - 2021-05-20

### Added

- `resizeMode` prop.

## [0.1.2] - 2021-04-26

### Added

- Typescript definitions.

## [0.1.1] - 2021-04-22

### Changed

- Don't mix MJS and CJS.

## [0.1.0] - 2021-04-15

### Added

- Initial release.

<!-- Markdown link dfn's -->

[unreleased]: https://github.com/klarna-incubator/react-native-vector-drawable/compare/v0.5.0...HEAD
[0.5.0]: https://github.com/klarna-incubator/react-native-vector-drawable/compare/v0.4.0...v0.5.0
[0.4.0]: https://github.com/klarna-incubator/react-native-vector-drawable/compare/v0.3.0...v0.4.0
[0.3.0]: https://github.com/klarna-incubator/react-native-vector-drawable/compare/v0.2.1...v0.3.0
[0.2.1]: https://github.com/klarna-incubator/react-native-vector-drawable/compare/v0.2.0...v0.2.1
[0.2.0]: https://github.com/klarna-incubator/react-native-vector-drawable/compare/v0.1.2...v0.2.0
[0.1.2]: https://github.com/klarna-incubator/react-native-vector-drawable/compare/v0.1.1...v0.1.2
[0.1.1]: https://github.com/klarna-incubator/react-native-vector-drawable/compare/v0.1.0...v0.1.1
[0.1.0]: https://github.com/klarna-incubator/react-native-vector-drawable/releases/tag/v0.1.0
