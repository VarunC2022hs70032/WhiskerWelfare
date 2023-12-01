## How to run?

The application can be run in development or production mode by applying the following steps.
<br/>

### Prerequisites

The following apps should be installed before running the application:

- A command line app
- Docker Desktop 

> **Note** <br/>
> For more information regarding the system requirements, etc. refer to the following pages: <br/>
> [Install on Mac](https://docs.docker.com/desktop/install/mac-install/)<br/>
> [Install on Windows](https://docs.docker.com/desktop/install/windows-install/)<br/>
> [Install on Linux](https://docs.docker.com/desktop/install/linux-install/)<br/>

<br/>

### Running app in Development mode

In order to run the application in development mode, apply the following steps:

1. Run Docker desktop.

<br/>


2. Open command prompt window and clone the project from GitHub using the following command:

```
git clone https://github.com/yildizmy/pet-clinic.git
```
<br/>



3. Change the current directory to the project directory where the `docker-compose.yml` file is in:

```
cd pet-clinic
```
<br/>


4. Run the following command (by running this command, the database container is built and starts up):

```
docker compose up --build
```

<br/>

5. Open backend project using IntelliJ IDEA and then select _Run > Edit Configurations_ and add the following values to the **Environment variables** field.  

```
DB_NAME=pet_clinic;DB_USERNAME=postgres;DB_PASSWORD=pass;JWT_SECRET=appSecretKey
```

> **Note**  <br/>
> If the _Environment variables_ field is not available, it can be added via _Modify options_ menu on the _Rub/Debug Configurations_ dialog (Alt+E).

<br/>

Then close the dialog and run the application.

> **Note** <br/>
> If _Lombok requires enabled annotation processing_ dialog appears at this stage, click _Enable annotation processing_ button.

<br/>

6. Open another command prompt window/tab and change the current directory to the frontend project:

```
cd pet-clinic/frontend
```
<br/>

7. Run the following commands respectively:

```
npm install
```

```
npm start
```

<br/>
<br/>

### User Accounts

```
username: johndoe
password: johnd@e
role: admin

username: lindacalvin
password: lindac@lvin
role: admin

username: jeffreytaylor
password: jeffreyt@ylor
role: user
```

<br/>