# Project 1 - *Movie App*

**Movie App** shows the latest movies currently playing in theaters. The app utilizes the Movie Database API to display images and basic information about these movies to the user.

Time spent: **12** hours spent in total

## User Stories

The following **required** functionality is completed:

* [ ] Expose details of movie (ratings using RatingBar, popularity, and synopsis) in a separate activity.

* [ ] Allow video posts to be played in full-screen using the YouTubePlayerView (2 points)

    * [ ] When clicking on a popular movie (i.e. a movie voted for more than 5 stars) the video should be played immediately.
    * [ ] Less popular videos rely on the detailed page should show an image preview that can initiate playing a YouTube video.


## Video Walkthrough

Here's a walkthrough of implemented user stories:

https://i.imgur.com/Abwhi6S.gif

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes

The only problem i had with this app is that the intent was not passing. I later found out that some of the activities were not included in the manifest file.

## Open-source libraries used

- [Android Async HTTP](https://github.com/loopj/android-async-http) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Android

## License

    Copyright [yyyy] [name of copyright owner]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
