# TimetableView
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![API](https://img.shields.io/badge/API-19%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=19)
[![](https://jitpack.io/v/omarb1989/TimetableView.svg)](https://jitpack.io/#omarb1989/TimetableView)

Android Library that creates simple time table.

![dark](https://user-images.githubusercontent.com/9026030/128323499-f8562b86-8f18-4cc3-a6b5-3165b03ad88b.jpg)
![light](https://user-images.githubusercontent.com/9026030/128323528-678ceab1-4dd8-40e1-a09b-e66b98ed0343.jpg)



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
	implementation 'omarb1989:TimetableView:1.0.4-fx4'
}
```

## Usage
Add following XML namespace inside your XML layout file.

```gradle
xmlns:app="http://schemas.android.com/apk/res-auto"
```

### TimetableView in layout
```xml
<omarb1989.timetableview.TimetableView
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
app:color_surface="#ffffff" // set default color of table boxes
app:color_borders="#F3F3F3" // set color for the table borders
app:side_color_text="#000000" //set color text of the first column of hours
app:color_side="#F48FB1" // set color of the first column of hours
app:color_side_header_text="#FFE082" // set color text of the header and the first column of hours
app:border_width="light" // set table border width: noWidth, light, normal, thick, extra thick
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
<omarb1989.timetableview.TimetableView
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
### OnStickerSelectedLongClickListener
OnStickerSelectedLongClickListener is invoked when Long clicked by user.

idx is used to edit or delete. 
```java
timetable.setOnStickerSelectEventListener(new TimetableView.OnStickerSelectedLongClickListener() {
            @Override
            public void OnStickerSelectedLongClick(int idx, ArrayList<Schedule> schedules) {
                
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
int uniqueId = schedule.get_id();// you can use it later on wherever you get schedule object to identify it
schedules.add(schedule);
//.. add one or more schedules
timetable.add(schedules);
int UniqueId = 
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
<omarb1989.timetableview.TimetableView
    android:id="@+id/timetable"
    android:layout_width="match_parent"
    android:layout_height="0dp"
    android:layout_weight="1"
    app:header_highlight_type="color" />
```
**2.Image type**
```xml
<omarb1989.timetableview.TimetableView
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
Copyright 2019 tlaabs, forked and updated by omarb1989

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
