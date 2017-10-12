# ButterToast
 CustomToast Library

 Under development 

## Some Screenshots
<img src = "https://github.com/chugh22/ButterToast/blob/master/screenshots/error.png">
<img src = "https://github.com/chugh22/ButterToast/blob/master/screenshots/warning.png">
<img src = "https://github.com/chugh22/ButterToast/blob/master/screenshots/info.png">
<img src = "https://github.com/chugh22/ButterToast/blob/master/screenshots/success.png">

### Prerequisites
Add this in your root `build.gradle` file (**not** your module `build.gradle` file):
```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

### Dependency

Add this to your modules `build.gradle` file

```
dependencies {
	        compile 'com.github.chugh22:ButterToast:0.1.1'
	}

```