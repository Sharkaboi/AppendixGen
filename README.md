**AppendixGen** is a Kotlin CLI tool to generate an appendix of all code in a folder to a markdown file.  

## Installation

* Install [Kotlin](https://kotlinlang.org/) or Java to run JAR files.
* Get the `AppendixGen.zip` file from [releases](https://github.com/Sharkaboi/AppendixGen/releases) and extract to a permanent location, preffarably to `C:\`.
* Copy full absolute address of folder `.\bin`.
* Add the address to System environment path variable.
* Run `AppendixGen -h` to test (`refreshenv` if using PS).

## Commands
- **Command is performed on current folder, so CD to directory you wish to generate appendix from.**  
- Generate `appendix.md` (Default file name) :   
    ```
    AppendixGen 
    ```
- To generate with custom file name :   
    ```
    AppendixGen --name source_code
    ```
  This generates `source_code.md`.
- For verbose operation use `-v` or `--verbose` argument with the above commands. 
  For example  
    ```
    AppendixGen --verbose
    AppendixGen -v
    AppendixGen --name source_code --verbose
    AppendixGen --name source_code -v
    ```
- For help in any section use `-h` or `--help` as so  
    ```
    AppendixGen -h
    AppendixGen --help
    ```
  
## Build instructions
- Install [Gradle](https://gradle.org/) and [Kotlin](https://kotlinlang.org/).
- Clone project.
- Open in Intellij and run gradle task `distrubution > installDist`   
  or run `gradle installDist`
- Copy full absolute address till `.\build\install\AppendixGen\bin`.
- Add the address to System environment path variable.
- Run `AppendixGen -h` to test (`refreshenv` is using PS).

## Assumptions
- Adds header to file code block with relative address from CD.
- Adds code block with language set to extension (Defaults to no formatting). 
If extension name is not same as language keyword, no formatting is done.
- Skips over any folder/address that contains `.git`.
- Skips over generated markdown file.
- Stops if file already exists.
- Stops if file RW permissions are not available.
- Visits files using DFS while visiting folders first.

## Tools used
- [Kotlin](https://kotlinlang.org/)
- [Gradle](https://gradle.org/)
- [Clikt](https://ajalt.github.io/clikt/)

## Contributing
PR's are welcome. Please try to follow the template.

## Licence
```
MIT License

Copyright (c) 2021 Sarath S

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

``` 
