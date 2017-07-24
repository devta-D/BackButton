# BackButton
 Simplify the process of handing back navigation through UI in android.
 
 Usage
--------
To implement BackButton view in to your project, add this BackButton library to your project and add BackButton in your layout XML. 
You can also grab it via Gradle:

Add it in your root build.gradle at the end of repositories:

```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

```groovy
compile 'com.github.devta-D:BackButton:v1.0.1'
```

or Maven:

```xml
<repositories>
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
</repositories>

<dependency>
	    <groupId>com.github.devta-D</groupId>
	    <artifactId>BackButton</artifactId>
	    <version>v1.0.1</version>
	</dependency>
version>
</dependency>
```

###XML
```xml
    <BackButton
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />
```

You may use the following properties in your XML to customize your BackButton.

#####Properties:

* `app:image`       (Drawable)             -> default black color

###JAVA

```java
    BackButton backButton = new BackButton(this);
```

# NOTE
* Just add the view through xml into the layout of activity, you don't have to initialize it in java and it will automatically start performing its operation.
* Default action of this view is to finish the current activity but if you want to add custom function to this view you have to add "BackButton.TopBackButtonEventListener" in to your activity java code as following:
```
Activity implements BackButton.TopBackButtonEventListener{

    @Override
    public void onTopBackButtonClicked() {
        //add your custom code here
    }
```

Developed By
--------

Divyanshu Tayal

<a href="https://www.linkedin.com/in/divyanshu-tayal-4a95b2aa/">
  <img alt="Follow me on LinkedIn"
       src="http://data.pkmmte.com/temp/social_linkedin_logo.png" />
</a>
