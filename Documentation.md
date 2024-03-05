## Animals
***AnimalSaveRequest***:
{ 
	"name": "String",
	"species": "String",
	"breed": "String",
	"gender": "String",
	"color": "String",
	"dateOfBirth": "LocalDate",
	"ownerId": "Long"
}
***AnimalUpdateRequest***:
{ 
	"name": "String",
	"species": "String",
	"breed": "String",
	"gender": "String",
	"color": "String",
	"dateOfBirth": "LocalDate",
	"ownerId": "Long"
}


### Save Animal

-   **URL:** `/v1/animals`
-   **Method:** `POST`
-   **Request Body:** AnimalSaveRequest
-   **Description:** Creates a new animal.
-   **Success Response:**
    -   **Code:** `201 CREATED`
    -   **Content:** AnimalResponse

### Get Animal by ID

-   **URL:** `/v1/animals/{id}`
-   **Method:** `GET`
-   **Path Parameters:** `id` (Long)
-   **Description:** Retrieves an animal by its ID.
-   **Success Response:**
    -   **Code:** `200 OK`
    -   **Content:** AnimalResponse

### Update Animal

-   **URL:** `/v1/animals/{id}`
-   **Method:** `PUT`
-   **Path Parameters:** `id` (Long)
-   **Request Body:** AnimalUpdateRequest
-   **Description:** Updates an existing animal.
-   **Success Response:**
    -   **Code:** `200 OK`
    -   **Content:** AnimalResponse

### Delete Animal

-   **URL:** `/v1/animals/{id}`
-   **Method:** `DELETE`
-   **Path Parameters:** `id` (Long)
-   **Description:** Deletes an animal by its ID.
-   **Success Response:**
    -   **Code:** `200 OK`

### Get Animals with Pagination

-   **URL:** `/v1/animals`
-   **Method:** `GET`
-   **Query Parameters:**
    -   `page` (int, optional, default: 0)
    -   `pageSize` (int, optional, default: 10)
-   **Description:** Retrieves animals with pagination support.
-   **Success Response:**
    -   **Code:** `200 OK`
    -   **Content:** CursorResponse<AnimalResponse>

### Find Animals by Name

-   **URL:** `/v1/animals/findByName`
-   **Method:** `GET`
-   **Query Parameters:**
    -   `name` (String)
-   **Description:** Finds animals by their name.
-   **Success Response:**
    -   **Code:** `200 OK`
    -   **Content:** List<AnimalResponse>
    - 
## Appointments
***AppointmentSaveRequest:***
{ 
	"date": "LocalDateTime",
	"doctorId": "Long",
	"animalId": "Long"
}
***AppointmentSaveRequest:***
{ 
	"date": "LocalDateTime",
	"doctorId": "Long",
	"animalId": "Long"
}


### Save Appointment

-   **URL:** `/v1/appointments`
-   **Method:** `POST`
-   **Request Body:** AppointmentSaveRequest
-   **Description:** Creates a new appointment.
-   **Success Response:**
    -   **Code:** `201 CREATED`
    -   **Content:** AppointmentResponse

### Get Appointment by ID

-   **URL:** `/v1/appointments/{id}`
-   **Method:** `GET`
-   **Path Parameters:** `id` (Long)
-   **Description:** Retrieves an appointment by its ID.
-   **Success Response:**
    -   **Code:** `200 OK`
    -   **Content:** AppointmentResponse

### Update Appointment

-   **URL:** `/v1/appointments/{id}`
-   **Method:** `PUT`
-   **Path Parameters:** `id` (Long)
-   **Request Body:** AppointmentUpdateRequest
-   **Description:** Updates an existing appointment.
-   **Success Response:**
    -   **Code:** `200 OK`
    -   **Content:** AppointmentResponse

### Delete Appointment

-   **URL:** `/v1/appointments/{id}`
-   **Method:** `DELETE`
-   **Path Parameters:** `id` (Long)
-   **Description:** Deletes an appointment by its ID.
-   **Success Response:**
    -   **Code:** `200 OK`

### Get Appointments with Pagination

-   **URL:** `/v1/appointments`
-   **Method:** `GET`
-   **Query Parameters:**
    -   `page` (int, optional, default: 0)
    -   `pageSize` (int, optional, default: 10)
-   **Description:** Retrieves appointments with pagination support.
-   **Success Response:**
    -   **Code:** `200 OK`
    -   **Content:** CursorResponse<AppointmentResponse>

### Find Appointments by Doctor ID and Date Range

-   **URL:** `/v1/appointments/findByDoctorIdAndDate`
-   **Method:** `GET`
-   **Query Parameters:**
    -   `doctorId` (Long)
    -   `startTime` (LocalDate)
    -   `endTime` (LocalDate)
-   **Description:** Finds appointments by doctor ID and date range.
-   **Success Response:**
    -   **Code:** `200 OK`
    -   **Content:** List<AppointmentResponse>

### Find Appointments by Animal ID and Date Range

-   **URL:** `/v1/appointments/findByAnimalIdAndDate`
-   **Method:** `GET`
-   **Query Parameters:**
    -   `animalId` (Long)
    -   `startTime` (LocalDate)
    -   `endTime` (LocalDate)
-   **Description:** Finds appointments by animal ID and date range.
-   **Success Response:**
    -   **Code:** `200 OK`
    -   **Content:** List<AppointmentResponse>
    
## Available Dates
***AvailableDateSaveRequest:***
{ 
	"date": "LocalDate",
	"doctorId": "Long"
}
***AvailableDateUpdateRequest:***
{ 
	"date": "LocalDate",
	"doctorId": "Long"
}

### Save Available Date

-   **URL:** `/v1/availabledates`
-   **Method:** `POST`
-   **Request Body:** AvailableDateSaveRequest
-   **Description:** Creates a new available date.
-   **Success Response:**
    -   **Code:** `201 CREATED`
    -   **Content:** AvailableDateResponse

### Get Available Date by ID

-   **URL:** `/v1/availabledates/{id}`
-   **Method:** `GET`
-   **Path Parameters:** `id` (Long)
-   **Description:** Retrieves an available date by its ID.
-   **Success Response:**
    -   **Code:** `200 OK`
    -   **Content:** AvailableDateResponse

### Update Available Date

-   **URL:** `/v1/availabledates/{id}`
-   **Method:** `PUT`
-   **Path Parameters:** `id` (Long)
-   **Request Body:** AvailableDateUpdateRequest
-   **Description:** Updates an existing available date.
-   **Success Response:**
    -   **Code:** `200 OK`
    -   **Content:** AvailableDateResponse

### Delete Available Date

-   **URL:** `/v1/availabledates/{id}`
-   **Method:** `DELETE`
-   **Path Parameters:** `id` (Long)
-   **Description:** Deletes an available date by its ID.
-   **Success Response:**
    -   **Code:** `200 OK`

----------

## Doctors
***DoctorSaveRequest:***

    { 
    	"name": "String",
    	"phone": "String",
    	"email": "String",
    	"address": "String",
    	"city": "String"
    }

***DoctorUpdateRequest:***

    { 
    	"name": "String",
    	"phone": "String",
    	"email": "String",
    	"address": "String",
    	"city": "String"
    }

### Save Doctor

-   **URL:** `/v1/doctors`
-   **Method:** `POST`
-   **Request Body:** DoctorSaveRequest
-   **Description:** Creates a new doctor.
-   **Success Response:**
    -   **Code:** `201 CREATED`
    -   **Content:** DoctorResponse

### Update Doctor

-   **URL:** `/v1/doctors/{id}`
-   **Method:** `PUT`
-   **Path Parameters:** `id` (Long)
-   **Request Body:** DoctorUpdateRequest
-   **Description:** Updates an existing doctor.
-   **Success Response:**
    -   **Code:** `200 OK`
    -   **Content:** DoctorResponse

### Delete Doctor

-   **URL:** `/v1/doctors/{id}`
-   **Method:** `DELETE`
-   **Path Parameters:** `id` (Long)
-   **Description:** Deletes a doctor by its ID.
-   **Success Response:**
    -   **Code:** `200 OK`

### Get Doctor by ID

-   **URL:** `/v1/doctors/{id}`
-   **Method:** `GET`
-   **Path Parameters:** `id` (Long)
-   **Description:** Retrieves a doctor by its ID.
-   **Success Response:**
    -   **Code:** `200 OK`
    -   **Content:** DoctorResponse

### Get Doctors with Pagination

-   **URL:** `/v1/doctors`
-   **Method:** `GET`
-   **Query Parameters:**
    -   `page` (int, optional, default: 0)
    -   `pageSize` (int, optional, default: 10)
-   **Description:** Retrieves doctors with pagination support.
-   **Success Response:**
    -   **Code:** `200 OK`
    -   **Content:** CursorResponse<DoctorResponse>

----------

## Owners
 ***OwnerSaveRequest:***

     { 
    	"name": "String",
    	"phone": "String",
    	"email": "String",
    	"address": "String",
    	"city": "String"
    }

***OwnerUpdateRequest:***

    { 
    	"name": "String",
    	"phone": "String",
    	"email": "String",
    	"address": "String",
    	"city": "String"
    }


### Save Owner

-   **URL:** `/v1/owners`
-   **Method:** `POST`
-   **Request Body:** OwnerSaveRequest
-   **Description:** Creates a new owner.
-   **Success Response:**
    -   **Code:** `201 CREATED`
    -   **Content:** OwnerResponse

### Get Owner by ID

-   **URL:** `/v1/owners/{id}`
-   **Method:** `GET`
-   **Path Parameters:** `id` (Long)
-   **Description:** Retrieves an owner by its ID.
-   **Success Response:**
    -   **Code:** `200 OK`
    -   **Content:** OwnerResponse

### Update Owner

-   **URL:** `/v1/owners/{id}`
-   **Method:** `PUT`
-   **Path Parameters:** `id` (Long)
-   **Request Body:** OwnerUpdateRequest
-   **Description:** Updates an existing owner.
-   **Success Response:**
    -   **Code:** `200 OK`
    -   **Content:** OwnerResponse

### Delete Owner

-   **URL:** `/v1/owners/{id}`
-   **Method:** `DELETE`
-   **Path Parameters:** `id` (Long)
-   **Description:** Deletes an owner by its ID.
-   **Success Response:**
    -   **Code:** `200 OK`

### Get Owners with Pagination

-   **URL:** `/v1/owners`
-   **Method:** `GET`
-   **Query Parameters:**
    -   `page` (int, optional, default: 0)
    -   `pageSize` (int, optional, default: 10)
-   **Description:** Retrieves owners with pagination support.
-   **Success Response:**
    -   **Code:** `200 OK`
    -   **Content:** CursorResponse<OwnerResponse>

### Find Owners by Name

-   **URL:** `/v1/owners/findByOwnerName`
-   **Method:** `GET`
-   **Query Parameters:**
    -   `name` (String)
-   **Description:** Finds owners by their name.
-   **Success Response:**
    -   **Code:** `200 OK`
    -   **Content:** List<OwnerResponse>

----------

## Vaccines
***VaccineSaveRequest***:

    { 
    	"name": "String",
    	"code": "String",
    	"startDate": "LocalDate",
    	"endDate": "LocalDate",
    	"animalId": "Long"
    }


***VaccineUpdateRequest***:

    { 
    	"name": "String",
    	"code": "String",
    	"startDate": "LocalDate",
    	"endDate": "LocalDate",
    	"animalId": "Long"
    }

### Save Vaccine

-   **URL:** `/v1/vaccines`
-   **Method:** `POST`
-   **Request Body:** VaccineSaveRequest
-   **Description:** Creates a new vaccine.
-   **Success Response:**
    -   **Code:** `201 CREATED`
    -   **Content:** VaccineResponse

### Get Vaccine by ID

-   **URL:** `/v1/vaccines/{id}`
-   **Method:** `GET`
-   **Path Parameters:** `id` (Long)
-   **Description:** Retrieves a vaccine by its ID.
-   **Success Response:**
    -   **Code:** `200 OK`
    -   **Content:** VaccineResponse

### Update Vaccine

-   **URL:** `/v1/vaccines/{id}`
-   **Method:** `PUT`
-   **Path Parameters:** `id` (Long)
-   **Request Body:** VaccineUpdateRequest
-   **Description:** Updates an existing vaccine.
-   **Success Response:**
    -   **Code:** `200 OK`
    -   **Content:** VaccineResponse

### Delete Vaccine

-   **URL:** `/v1/vaccines/{id}`
-   **Method:** `DELETE`
-   **Path Parameters:** `id` (Long)
-   **Description:** Deletes a vaccine by its ID.
-   **Success Response:**
    -   **Code:** `200 OK`

### Get Vaccines with Pagination

-   **URL:** `/v1/vaccines`
-   **Method:** `GET`
-   **Query Parameters:**
    -   `page` (int, optional, default: 0)
    -   `pageSize` (int, optional, default: 10)
-   **Description:** Retrieves vaccines with pagination support.
-   **Success Response:**
    -   **Code:** `200 OK`
    -   **Content:** CursorResponse<VaccineResponse>

### Find Vaccines by Animal ID

-   **URL:** `/v1/vaccines/findByAnimalId`
-   **Method:** `GET`
-   **Query Parameters:**
    -   `animalId` (Long)
-   **Description:** Finds vaccines by animal ID.
-   **Success Response:**
    -   **Code:** `200 OK`
    -   **Content:** List<VaccineResponse>

### Find Vaccines by Date Range

-   **URL:** `/v1/vaccines/findByVaccineDates`
-   **Method:** `GET`
-   **Query Parameters:**
    -   `startDate` (LocalDate)
    -   `endDate` (LocalDate)
-   **Description:** Finds vaccines within a specified date range.
-   **Success Response:**
    -   **Code:** `200 OK`
    -   **Content:** List<VaccineResponse>
