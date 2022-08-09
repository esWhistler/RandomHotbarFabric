# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]
### Fixed
- GUI was now overlapping with the name of the held block, I really need to find a better place for the percentage numbers

## [0.4.0]
### Changed
- Mod now includes the fabric API modules it requires, so fabric API is no longer a needed dependency (although it's still necessary for amecs)

### Fixed
- Game would crash if config directory wasn't present on game starting
- Non-amecs version wasn't updating the configuration in game after changing it
- GUI overlap in Adventure and Survival mode

## [0.3.1]
### Fixed
- Game would crash if you had a config file created by an earlier version of the mod and then used the 0.3.0 version

## [0.3.0]
### Added
- It's now required that percentages add up to 100 in every preset before being able to save the configurations in game
- Transparency when opening the config screen in game

## [0.2.0]
### Changed
- Mod now turns off in spectator mode
- Randomizer on/off message now is a text overlay to avoid clogging the chat

### Fixed
- GUI overlap in Adventure and Survival mode
- Randomizer is not activating anymore when placing a block from a slot with a 0% chance

## [0.1.0]
### Added
- First Pre-Release

[Unreleased]: https://github.com/esWhistler/RandomHotbarFabric/compare/0.4.0-1.18.2...HEAD
[0.4.0]: https://github.com/esWhistler/RandomHotbarFabric/compare/0.3.1-1.18.2...0.4.0-1.18.2
[0.3.1]: https://github.com/esWhistler/RandomHotbarFabric/compare/0.3.0-1.18.2...0.3.1-1.18.2
[0.3.0]: https://github.com/esWhistler/RandomHotbarFabric/compare/0.2.0-1.18.2...0.3.0-1.18.2
[0.2.0]: https://github.com/esWhistler/RandomHotbarFabric/compare/0.1.0-1.18.2...0.2.0-1.18.2
[0.1.0]: https://github.com/esWhistler/RandomHotbarFabric/releases/tag/0.1.0-1.18.2
