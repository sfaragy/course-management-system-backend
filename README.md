# How to run the project
1. Clone the repo or extract the content
2. Run the project in linux / Mac:
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
      3. MacOs
      ```
      brew install make
      ```
   2. Run the following command to build images & start project:
      1. Build images: 
        ``` make build```
      2. Create Database: (if the database didn't create automatically and showing any issue)
      ```make create-db```
      3. Start the project:
        ```make start```
      3. Stop the project:
      ```make stop```
   3. Test the project in specific URL in localhost:
    ```https://localhost:8080```

# Requested endpoints:
   With data initialization I have added 100 students and 10 test courses. So, I assume we are authorized to 
   signup for course. Farther implementation we need to add Auth 2.0 (Authentication  / Authorization)
   
   API host: http://localhost:8080

## 1. Course Sign Up "/minden-api/v1/course-registration"
Sign up for a course with the following request body.

         POST /minden-api/v1/course-registration

Request Body:
   1. **courseId**: Real number, Id of the course that the student interested to sign up. (Required)
   2. **studentId**:  Real number, Id of the student. (Required)
      ```
      {
         "courseId": courseId,
         "studentId": studentId
      }
      ```
Example Request Body:
         
            {
               "courseId": 1,
               "studentId": 51
            }

Respons:
```
1. Success Status 201: Successfully signed up for course Course 5 (course_id)
2. Failure Status 400: Course registration already exists.
 ```
## 2. List all courses that the student already signed up "/minden-api/v1/student/{student_id}/courses"
Get all signed up courses by the student.

         GET /minden-api/v1/student/{studentId}/courses
         i.e. GET /minden-api/v1/student/51/courses

Request Attributes:
   1. **studentId**:  Real number, Id of the student to get all the registered courses those are active. (Required)

Response:

         [
            {
               _"registration_id": 5,
               "course_id": 1,
               "course_name": "Course 1",
               "status": "ACTIVE",
               "registration_date": "2024-05-07T07:51:47.327+00:00"_
            },
            {
               "registration_id": 6,
               "course_id": 5,
               "course_name": "Course 5",
               "status": "ACTIVE",
               "registration_date": "2024-05-07T09:25:16.027+00:00"
            },
            {
               "registration_id": 7,
               "course_id": 4,
               "course_name": "Course 4",
               "status": "ACTIVE",
               "registration_date": "2024-05-07T09:26:51.584+00:00"
            }
         ]

         
## 3. Cancel Sign-up from a course that the student already signed up and active
"minden-api/v1/student/{studentId}/courses/{courseId}"

Cancel Sign up for a course that the student already registered.

         DELETE /minden-api/v1/student/{student_id}/courses/{course_id}
         i.e. DELETE /minden-api/v1/student/51/courses/1

Request Attributes:
1. **courseId**: Real number, Id of the course that the student interested to cancel sign up. (Required)
2. **studentId**:  Real number, Id of the student. (Required)


Example Response:
1. Success Status 201: Successfully cancel the course
2. Failure Status 400: Failed to cancel the course registration!.
 
            
## 4. List classmates those signed up for the same course that the student already signed up and currently active active "minden-api/v1/student/{studentId}/courses/{courseId}"

         GET /minden-api/v1/student/51/classmates/1
         i.e. GET /minden-api/v1/student/{studentId}/classmates/{courseId}

Request Attributes:
1. **courseId**: Real number, Id of  the course to find all students those signed up for the specific course. (Required)
2. **studentId**:  Real number, Id of the student. (Required)
Example Response:
```
[
    {
        "id": 44,
        "student_name": "Student 44",
        "student_email": "student44@minden-rest-api.com"
    },
    {
        "id": 45,
        "student_name": "Student 45",
        "student_email": "student45@minden-rest-api.com"
    },
    {
        "id": 46,
        "student_name": "Student 46",
        "student_email": "student46@minden-rest-api.com"
    },
    {
        "id": 50,
        "student_name": "Student 50",
        "student_email": "student50@minden-rest-api.com"
    }
]
```