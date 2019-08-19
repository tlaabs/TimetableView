# TimetableView
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![API](https://img.shields.io/badge/API-19%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=19)
[![](https://jitpack.io/v/tlaabs/TimetableView.svg)](https://jitpack.io/#tlaabs/TimetableView)

Android Library that creates simple time table.


![img0](https://postfiles.pstatic.net/MjAxOTAxMjdfMTUz/MDAxNTQ4NTcyNTU5NTk4.M9hWyDvljjkoBDW-naLrTRqRAXUM8WRUyZXptTLKbs8g.b0FN12d8Cmxp5OWZqlQcusL_mJYNKgx6a_XLe_1ALOog.JPEG.tlaabs/Screenshot_Air.jpg?type=w773)
![img1](https://user-images.githubusercontent.com/8165219/62833150-b88d3180-bc74-11e9-9b20-02a0ad03e778.jpg) 


## How to import
Add it in your root build.gradle
```gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
Add the dependency
```gradle
dependencies {
	implementation 'com.github.tlaabs:TimetableView:1.0.3-fx1'
}
```

## Usage
Add following XML namespace inside your XML layout file.

```gradle
xmlns:app="http://schemas.android.com/apk/res-auto"
```

### TimetableView in layout
```xml
<com.github.tlaabs.timetableview.TimetableView
        android:id="@+id/timetable"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:column_count="6"
        app:row_count="12" />
```

### Attribute descriptions
```gradle
app:row_count="12" // sets number of table rows (default:12)
app:column_count="6" // sets number of table column (default:6)
app:cell_height="50dp" // sets table cell height (default:50dp)
app:side_cell_width="30dp" // sets left side cell width (default:30dp)
app:header_title="@array/my_header_title" // sets header title (default:eng)
app:sticker_colors="@array/my_sticker_color" // sets schedule sticker colors
app:start_time="9" // sets start time (range : 0 ~ 24)
app:header_highlight_color="@color/highlight" // sets header highlight color (default : #74a4f3)
app:header_highlight_image="@drawable/ic_kitty" // set header highlight image src
app:header_highlight_image_size="36dp" // set header highlight image width,height(square)
app:header_highlight_type="image" // set header highlight type - color/image (default : color)
```

### Change header title
First, write a string-array as below on values/strings.xml. 
```xml
<string-array name="my_header_title">
    <item></item>
    <item>Mon</item>
    <item>Tue</item>
    <item>Wed</item>
    <item>Thu</item>
    <item>Fri</item>
</string-array>
```
Then, apply that to timetable attribute.
```xml
<com.github.tlaabs.timetableview.TimetableView
    android:id="@+id/timetable"
    android:layout_width="match_parent"
    android:layout_height="0dp"
    android:layout_weight="1"
    app:header_title="@array/my_header_title" />
```

### OnStickerSelectedListener
OnStickerSelectedListener is invoked when clicked by user.

idx is used to edit or delete. 
```java
timetable.setOnStickerSelectEventListener(new TimetableView.OnStickerSelectedListener() {
    @Override
    public void OnStickerSelected(int idx, ArrayList<Schedule> schedules) {
        // ...
    }
});
```

### Add schdule
```java
ArrayList<Schedule> schedules = new ArrayList<Schedule>();
Schedule schedule = new Schedule();
schedule.setClassTitle("Data Structure"); // sets subject
schedule.setClassPlace("IT-601"); // sets place
schedule.setProfessorName("Won Kim"); // sets professor
schedule.setStartTime(new Time(10,0)); // sets the beginning of class time (hour,minute)
schedule.setEndTime(new Time(13,30)); // sets the end of class time (hour,minute)
schedules.add(schedule);
//.. add one or more schedules
timetable.add(schedules);
```

### Edit schedule
Before you edit,you need to get a sticker idx by using OnStickerSelectedListener.
```java
timetable.edit(idx,schedules);
```

### Delete schdule
```java
timetable.remove(idx);
timetable.removeAll(); // remove all items
```

### Highlight header
**1.Color type(Default)**
```xml
<com.github.tlaabs.timetableview.TimetableView
    android:id="@+id/timetable"
    android:layout_width="match_parent"
    android:layout_height="0dp"
    android:layout_weight="1"
    app:header_highlight_type="color" />
```
**2.Image type**
```xml
<com.github.tlaabs.timetableview.TimetableView
    android:id="@+id/timetable"
    android:layout_width="match_parent"
    android:layout_height="0dp"
    android:layout_weight="1"
    app:header_highlight_image="@drawable/ic_kitty"
    app:header_highlight_image_size="36dp"
    app:header_highlight_type="image" />
```
Then,
```java
timetable.setHeaderHighlight(idx);
```

### Restore and save
Using SaveManager, you can save all timetable schdule datas in json format.
```java
String json = timetable.createSaveData(); // save
timetable.load(json); // restore
```

# License
```xml
Copyright 2019 tlaabs

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
