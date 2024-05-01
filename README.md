# How to run the project
1. Clone the repo or extract the content
2. Run the project in linux:
   1. Install make if it is not installed in your system:
      1. Ubuntu: 
      ```
      sudo apt update
      sudo apt-get install make
      ```
      2. CentOs:
      ```
      yum install make
      ```
   2. Run the following command to build images & start project:
      1. Build images: 
        ``` make build```
      2. Start the project:
        ```make start```
      3. Stop the project:
      ```make stop```
   3. Test the project in specific URL in localhost:
    ```https://localhost:6868```