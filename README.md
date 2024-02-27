# Assignment 3
[Github project](https://github.com/rael346/cs-4520-assignment-3)

## Project structure
- Entry point: `MainActivity.kt`
- `ui` folder: contains the screens for the application
  - `mvp`: Fragment, Model and Presenter of the MVP implementation
    - `MVPModel`: performs the calculation (this doesn't store any state since there is no point in storing the numbers)
    - `MVPPresenter`: connects to the model for the calculation and use the Fragment to display the results/errors
    - `MVPFragment`: the view, responsible for displaying the results and errors
  - `mvvm`: Fragment, and ViewModel of the MVVM implementation
    - `MVVMViewModel`: calculate the result, set the result or error
    - `MVVMFragment`: observe the errors from the view model and 
  - `MainFragment`: The starting screen to the app

## Build
- I use the Pixel 5 API 34 for testing
