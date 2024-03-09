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


| Operation               | URL                        | Method | Request Body       | Description                                                                                   | Success Response            |
|-------------------------|----------------------------|--------|--------------------|-----------------------------------------------------------------------------------------------|------------------------------|
| Save Animal             | /v1/animals                | POST   | AnimalSaveRequest  | Creates a new animal.                                                                        | 201 CREATED, Content: AnimalResponse |
| Get Animal by ID        | /v1/animals/{id}           | GET    | Path Parameters: id | Retrieves an animal by its ID.                                                               | 200 OK, Content: AnimalResponse |
| Update Animal           | /v1/animals/{id}           | PUT    | Path Parameters: id, AnimalUpdateRequest | Updates an existing animal.                                                                   | 200 OK, Content: AnimalResponse |
| Delete Animal           | /v1/animals/{id}           | DELETE | Path Parameters: id | Deletes an animal by its ID.                                                                  | 200 OK                       |
| Get Animals with Pagination | /v1/animals            | GET    | Query Parameters: page (int, optional, default: 0), pageSize (int, optional, default: 10) | Retrieves animals with pagination support.                                                   | 200 OK, Content: CursorResponse |
| Find Animals by Name    | /v1/animals/findByName    | GET    | Query Parameters: name (String) | Finds animals by their name.                                                                | 200 OK, Content: List         |

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

| Operation                        | URL                                     | Method | Request Body              | Description                                                      | Success Response                |
|----------------------------------|-----------------------------------------|--------|---------------------------|------------------------------------------------------------------|--------------------------------|
| Save Appointment                 | /v1/appointments                        | POST   | AppointmentSaveRequest    | Creates a new appointment.                                       | 201 CREATED, Content: AppointmentResponse |
| Get Appointment by ID            | /v1/appointments/{id}                   | GET    | Path Parameters: id       | Retrieves an appointment by its ID.                              | 200 OK, Content: AppointmentResponse |
| Update Appointment               | /v1/appointments/{id}                   | PUT    | Path Parameters: id, AppointmentUpdateRequest      | Updates an existing appointment.                                 | 200 OK, Content: AppointmentResponse |
| Delete Appointment               | /v1/appointments/{id}                   | DELETE | Path Parameters: id       | Deletes an appointment by its ID.                                | 200 OK                         |
| Get Appointments with Pagination | /v1/appointments                        | GET    | Query Parameters: page (int, optional, default: 0), pageSize (int, optional, default: 10) | Retrieves appointments with pagination support.                 | 200 OK, Content: CursorResponse |
| Find Appointments by Doctor ID and Date Range | /v1/appointments/findByDoctorIdAndDate | GET    | Query Parameters: doctorId (Long), startTime (LocalDate), endTime (LocalDate) | Finds appointments by doctor ID and date range.               | 200 OK, Content: List          |
| Find Appointments by Animal ID and Date Range | /v1/appointments/findByAnimalIdAndDate | GET    | Query Parameters: animalId (Long), startTime (LocalDate), endTime (LocalDate) | Finds appointments by animal ID and date range.               | 200 OK, Content: List          |

    
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

| Operation                 | URL                            | Method | Request Body                 | Description                               | Success Response             |
|---------------------------|--------------------------------|--------|------------------------------|-------------------------------------------|-----------------------------|
| Save Available Date       | /v1/availabledates            | POST   | AvailableDateSaveRequest    | Creates a new available date.             | 201 CREATED, Content: AvailableDateResponse |
| Get Available Date by ID  | /v1/availabledates/{id}       | GET    | Path Parameters: id          | Retrieves an available date by its ID.    | 200 OK, Content: AvailableDateResponse |
| Update Available Date     | /v1/availabledates/{id}       | PUT    | Path Parameters: id, AvailableDateSUpdateRequest | Updates an existing available date.       | 200 OK, Content: AvailableDateResponse |
| Delete Available Date     | /v1/availabledates/{id}       | DELETE | Path Parameters: id          | Deletes an available date by its ID.      | 200 OK                      |


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

| Operation             | URL                      | Method | Request Body          | Description                          | Success Response             |
|-----------------------|--------------------------|--------|------------------------|--------------------------------------|-----------------------------|
| Save Doctor           | /v1/doctors             | POST   | DoctorSaveRequest     | Creates a new doctor.                | 201 CREATED, Content: DoctorResponse |
| Update Doctor         | /v1/doctors/{id}        | PUT    | Path Parameters: id, DoctorUpdateRequest | Updates an existing doctor.   | 200 OK, Content: DoctorResponse |
| Delete Doctor         | /v1/doctors/{id}        | DELETE | Path Parameters: id    | Deletes a doctor by its ID.          | 200 OK                      |
| Get Doctor by ID      | /v1/doctors/{id}        | GET    | Path Parameters: id    | Retrieves a doctor by its ID.        | 200 OK, Content: DoctorResponse |
| Get Doctors with Pagination | /v1/doctors     | GET    | Query Parameters: page, pageSize | Retrieves doctors with pagination support. | 200 OK, Content: CursorResponse |


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


| Operation             | URL                      | Method | Request Body          | Description                          | Success Response             |
|-----------------------|--------------------------|--------|------------------------|--------------------------------------|-----------------------------|
| Save Owner            | /v1/owners              | POST   | OwnerSaveRequest      | Creates a new owner.                 | 201 CREATED, Content: OwnerResponse |
| Update Owner          | /v1/owners/{id}         | PUT    | Path Parameters: id, OwnerUpdateRequest | Updates an existing owner.  | 200 OK, Content: OwnerResponse |
| Delete Owner          | /v1/owners/{id}         | DELETE | Path Parameters: id    | Deletes an owner by its ID.          | 200 OK                      |
| Get Owner by ID       | /v1/owners/{id}         | GET    | Path Parameters: id    | Retrieves an owner by its ID.        | 200 OK, Content: OwnerResponse |
| Get Owners with Pagination | /v1/owners         | GET    | Query Parameters: page, pageSize | Retrieves owners with pagination support. | 200 OK, Content: CursorResponse |
| Find Owners by Name   | /v1/owners/findByOwnerName | GET | Query Parameters: name | Finds owners by their name. | 200 OK, Content: List   |


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

| Operation             | URL                         | Method | Request Body             | Description                               | Success Response                |
|-----------------------|-----------------------------|--------|---------------------------|-------------------------------------------|--------------------------------|
| Save Vaccine          | /v1/vaccines               | POST   | VaccineSaveRequest       | Creates a new vaccine.                    | 201 CREATED, Content: VaccineResponse |
| Update Vaccine        | /v1/vaccines/{id}          | PUT    | Path Parameters: id, VaccineUpdateRequest | Updates an existing vaccine.    | 200 OK, Content: VaccineResponse |
| Delete Vaccine        | /v1/vaccines/{id}          | DELETE | Path Parameters: id       | Deletes a vaccine by its ID.              | 200 OK                         |
| Get Vaccine by ID     | /v1/vaccines/{id}          | GET    | Path Parameters: id       | Retrieves a vaccine by its ID.            | 200 OK, Content: VaccineResponse |
| Get Vaccines with Pagination | /v1/vaccines         | GET    | Query Parameters: page, pageSize | Retrieves vaccines with pagination support. | 200 OK, Content: CursorResponse |
| Find Vaccines by Animal ID | /v1/vaccines/findByAnimalId | GET | Query Parameters: animalId | Finds vaccines by animal ID.       | 200 OK, Content: List       |
| Find Vaccines by Date Range | /v1/vaccines/findByVaccineDates | GET | Query Parameters: startDate, endDate | Finds vaccines within a specified date range. | 200 OK, Content: List       |

