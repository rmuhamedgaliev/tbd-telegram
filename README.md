# 🛩 TBD Telegram SDK

![Maven Central](https://img.shields.io/maven-central/v/dev.tobee/tbd-telegram-sdk?style=flat-square)
![Check PR](https://github.com/rmuhamedgaliev/tbd-telegram/actions/workflows/github-actions-check_pr.yml/badge.svg)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=rmuhamedgaliev_tbd-telegram&metric=alert_status)](https://sonarcloud.io/dashboard?id=rmuhamedgaliev_tbd-telegram)

## TOC

- [Description](#description)
- [Instalation](#Instalation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Description

TBD Telegram SDK - a simple Java [Telegram BOT Api](https://core.telegram.org/bots/api) client. It have small footprint and use Java 11 async HTTP client 
with latest Java syntax.

## Instalation

Add Maven dependency

```xml
<dependency>
    <groupId>dev.tobee</groupId>
    <artifactId>tbd-telegram-sdk</artifactId>
    <version>0.1.13</version>
</dependency>
```

Or in gradle

```kotlin
implementation("dev.tobee:tbd-telegram-sdk:0.1.13")
```

## Usage

Create new [Java Flow Api Subscriber](https://docs.oracle.com/javase/9/docs/api/java/util/concurrent/Flow.html)
according your aim.

```java
package dev.tobee.telegram.demo;

import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.Flow;

import dev.tobee.telegram.client.TelegramApiClient;
import dev.tobee.telegram.model.message.Update;
import dev.tobee.telegram.request.body.SendMessageBody;
import dev.tobee.telegram.request.message.SendMessage;

public class EchoSubscriber implements Flow.Subscriber<Update> {

    private final TbdAsyncClient asyncClient;
    private Flow.Subscription subscription;

    public EchoSubscriber(TbdAsyncClient asyncClient) {
        this.asyncClient = asyncClient;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(Update item) {
        asyncClient.postRequest(new SendMessage(new SendMessageBody(
                item.message().orElseThrow().chat().id(),
                item.message().orElseThrow().text().orElseThrow(),
                Optional.empty(),
                Collections.emptyList(),
                Optional.empty(),
                Optional.of(Boolean.FALSE),
                Optional.empty(),
                item.message().orElseThrow().messageId(),
                Optional.empty(),
                Optional.empty()
        )));
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throw new RuntimeException("Error on handle message");
    }

    @Override
    public void onComplete() {
    }
}
```

And init bot

```java
package dev.tobee.telegram.demo;

import java.util.Collections;

import dev.tobee.telegram.LongPollingTelegramBot;
import dev.tobee.telegram.client.TelegramApiClient;

public class DemoBot {
    private static final String HOST = "https://api.telegram.org";

    public static void main(String[] args) {
        var token = System.getenv().get("TBD_TELEGRAM_TOKEN");
        var tbdClient = new TbdAsyncClient(false, HOST, token);
        var bot = new LongPollingTelegramBot(tbdClient, Collections.singletonList(new EchoSubscriber(tbdClient)));
        bot.subscribeToUpdate();
    }
}
```

Now you can test bot. Full example
in [demo](https://github.com/rmuhamedgaliev/tbd-telegram/tree/master/src/test/java/dev/tobee/telegram/demo)

## Contributing

Please read [contributing guide](./CONTRIBUTING.md).

## License

This project is licensed under the [MIT License](LICENSE).
