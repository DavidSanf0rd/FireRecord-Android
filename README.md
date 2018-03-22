# FireRecord-Android

[ ![Download](https://api.bintray.com/packages/sanf0rd/maven/FireRecord/images/download.svg) ](https://bintray.com/sanf0rd/maven/FireRecord/_latestVersion)

FireRecord is a framework written in kotlin which brings the ActiveRecord architecture as a wrapper to Firebase SDK on Android. The main idea is to make Android developing with Firebase ([Firestore](https://firebase.google.com/docs/firestore) and [Storage](https://firebase.google.com/docs/storage)) still more productive with the well-known [Active Record Pattern](http://guides.rubyonrails.org/active_record_basics.html) from [Rails community](http://rubyonrails.org/community).

If you liked this library take a look at the [iOS Swift version](https://github.com/victoraliss0n/FireRecord)

## Usage

### Inherit from FireRecord

```kotlin
class User: FireRecord() {
  companion object: FireRecordCompanion<User>()

  var name: String? = null
  var age: Int? = null
  var birthDate: Date? = null
  @ServerTimestamp var createdAt: Date? = null
}
```

### Init your model
```kotlin
val user = User()
user.name = "Jhon"
user.age = 19
```

### Save
```kotlin
user.save { print("User saved on Firestore") }
```

### Read
```kotlin
User.all { users ->
  users.forEach { print(it.name)}
}

User.load(id = "documentId") { user ->
  print(user.name)
}
```

### Update
```kotlin
user.name = "My new Name"
user.update { print("updated user um Firestore") }
```

### Delete
```kotlin
user.destroy { print("this user was deleted on Firestore") }
```

## Features

- [x] Basic CRUD functionality with Firestore
- [ ] Map queries from firestore
- [ ] Manage image/file properties (send/retrieve from Storage)
- [ ] Add realtime capabilities
- [ ] Add offline capabilities

## Requirements

[Add Firebase to your project](https://firebase.google.com/docs/android/setup)

## Installation

Add Firestore and FireRecord to your app build.gradle

```groovy
dependencies {
  // ...
  implementation 'com.google.firebase:firebase-core:11.8.0'
  implementation 'com.sanford.firerecord:firerecord:0.1'
}
```

## License

FireRecord is available under the MIT license. See the LICENSE file for more info.
