<!-- This file is rendered by https://github.com/BlvckBytes/readme_helper -->

# sixteen_segment_display

<!-- #toc -->

## Overview

The following drawing represents the dimensions of the displays I've ordered a long time ago on aliexpress.

![Display Dimensions](./readme_images/display_dimensions.jpg)

The following high level diagram provides a quick overview of how groups of four displays each are talked to.

![Interface Overview](./readme_images/interface_overview.jpg)

## PCB

### display_group

Four sixteen segment displays are considered to be a group.

![Display Group Layout](./readme_images/layout__display_group.png)

![Display Group Front](./readme_images/board__display_group__front.png)

![Display Group Back](./readme_images/board__display_group__back.png)

### interface

The interface board drives a display group by converting the serial signal into all sixteen segments, including the decimal point, as well as each display's enabled state.

![Interface Layout](./readme_images/layout__interface.png)

![Interface Front](./readme_images/board__interface__front.png)

![Interface Back](./readme_images/board__interface__back.png)

### display_group_and_interface

This board tries to combine both the [Interface](#interface)- as well as the [Display Group Board](#display_group) to save not only on space, but also on the four extra connectors. While it's getting quite crowded, this board should still be manufacturable at home.

There are 35 vias in total, of which 21 are unavoidable (16 segments, 1 decimal point, 4 ground lines, which all have to make it from the front side to the back, where the interface lives), making for 14 "additional" vias. I think that's an acceptable compromise.

![Display Group And Interface Layout](./readme_images/layout__display_grop_and_interface.png)

![Display Group And Interface Front](./readme_images/board__display_grop_and_interface__front.png)

![Display Group And Interface Back](./readme_images/board__display_grop_and_interface__back.png)

### driver

Has yet to be implemented.

The driver board resembles the bridge between modern devices and the display while also handling the process of detecting the total number of displays, handling the character decoding process, multiplexing displays and playing various animations, like blinking letters or scrolling text.

## Software

### SegmentStates

This project encodes all available segment states in order to display various characters. A decoding table is then generated from this information.

![states](./readme_images/state_image.jpg)

### SegmentDriver

Has yet to be implemented.

This project resembles the firmware of the [Driver Board](#driver).