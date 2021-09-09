# Contributing

When contributing to this repository, please first discuss the change you wish to make via issue, email, or any other method with the owners of this repository before making a change.

## Pull Request Process

1. Ensure any install or build dependencies are removed before the end of the layer when doing a build.
2. Update the README.md with details of changes to the interface, this includes new environment variables, exposed ports, useful file locations and container parameters.
3. Increase the version numbers in any examples files and the `README.md` to the new version that this pull request would represent. The versioning scheme we use is [SemVer](http://semver.org/).

## Development requirements

- JDK 16
- Gradle 7.2
- Intellij Idea

For start development fork [repository](https://github.com/rmuhamedgaliev/tbd-telegram). Then import project in your 
IDE, after index create new branch for your code.

Before create new feature please follow [guide](https://core.telegram.org/bots#3-how-do-i-create-a-bot) for create 
test telegram bot. After set `TBD_TELEGRAM_TOKEN` environment variable according you OS, for test features and 
telegram api.

Please send PR to [tbd-telegram](https://github.com/rmuhamedgaliev/tbd-telegram) repository.

For any new feature please write integration test, for check how to work in real telegram cleint.

## Contact

For any questions please contact me in telegram [@rmuhamedgaliev](https://t.me/rmuhamedgaliev)

