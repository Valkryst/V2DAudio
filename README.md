[![Release](https://jitpack.io/v/Valkryst/V2DAudio.svg)](https://jitpack.io/#Valkryst/V2DAudio) [![Total alerts](https://img.shields.io/lgtm/alerts/g/Valkryst/V2DAudio.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/Valkryst/V2DAudio/alerts/) [![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/Valkryst/V2DAudio.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/Valkryst/V2DAudio/context:java)

## Jar Files & Maven

The Maven dependency is hosted off of JitPack, so you will need to add JitPack as a repository before you add
V2DAudio as a dependency.

### Maven

JitPack:

```xml=
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

Dependency:

```xml
<dependency>
    <groupId>com.github.Valkryst</groupId>
    <artifactId>V2DAudio</artifactId>
    <version>2020.02.01</version>
</dependency>
```

## Important Notes

* Effect/MusicSettings objects can be reused, so you can use the same object with multiple different music
    tracks and effects.
* You _**must**_ exit your program by calling `System.exit(0)`.
    * The JavaFX runtime is kept open, in the background, so that this library can make use of the AudioClip,
        Media, and MediaPlayer classes. 
    * If you do not manually exit the application, with `System.ext(0)` where appropriate, then it will 
        remain open in the background, until the user either forcefully closes it or the system is shut down.

## Code Examples

Initializing the AudioController with a JSON file.

```java
final AudioController controller = AudioController.getInstance();
controller.initialize(Paths.get("./test_res/data-valid.json"));
```

### Playing Music & Effects
#### Without Settings
Playing a piece of music.

```java
final Music music = controller.loadMusic("victory");
music.play(null);
```

Playing an effect.

```java
final Effect effect = controller.loadEffect("thunder 2");
effect.play(null);
```

#### With Settings
Playing a piece of music.

```java
final MusicSettings settings = new MusicSettings();
settings.setVolume(0.5);

final Music music = controller.loadMusic("victory");
music.play(settings);
```

Playing an effect.

```java
final EffectSettings settings = new EffectSettings();
settings.setCycleCount(2);

final Effect effect = controller.loadEffect("thunder 2");
effect.play(settings);
```

## JSON File Example

* type - Either "effect" or "music".
* name - A unique ID for the sprite.
    * Capital letters are ignored, so the words "Victory", "ViCtoRy", and "VICTORY" are all considered to be
        the same.
* path - The relative, or absolute, path to the file.
   * This _must_ begin with "./" if the filesystem is set to "jar".
   * This _must_ begin with "./" if the file is relative to the folder that the JAR is running from.
* filesystem - Either "local" or "jar".

```json
[
    {
        "type": "effect",
        "name": "thunder 1",
        "path": "./test_res/effect_1.mp3",
        "filesystem": "local"
    },
    {
        "type": "effect",
        "name": "thunder 2",
        "path": "./test_res/effect_2.mp3",
        "filesystem": "local"
    },
    {
        "type": "music",
        "name": "victory",
        "path": "./test_res/music_1.wav",
        "filesystem": "local"
    }
]
```