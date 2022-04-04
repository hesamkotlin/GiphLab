# GiphLab
This is a project with Giphy API and implemented with MVVM. It's written fully with Kotlin with the help of Hilt, Coroutine, and some other jetpack components.
For Resume APP

Architecture
The project is implemented with MVVM and it's written fully with Kotlin. 

DI
I used hilt because of fewer boilerplate codes. 

Coroutine
For the threading and observing, I could use technologies like Livedata.In this moment that i typed this line i got some help from some friends to use coroutine(4.4.2022)

Data Persistence
My first approach here was Offline first, but because I wanted to reduce the complexity in this test project I decided to fetch data from the server every time it is needed, but for storing and accessing user's favorite gifs I made a local database with the help of Room library. I wrote some codes with offline-first approach and I pushed them on another branch (offline-first branch). I'm warning you that the branch doesn't work properly and just some of the features had been implemented there but It can give you the idea of how my offline approach would work.

UX
I kept UI minimal and tried to just show I know how to use things like constraintlayout, etc, but I guess from the user side it's not good at all :)

