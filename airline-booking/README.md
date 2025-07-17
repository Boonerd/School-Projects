# Airline Booking System

## Project Description
The Airline Booking System is a web application built using Django, designed to allow users to book flights, manage reservations, and search for available flights. The system provides a user-friendly interface for travelers to book flights based on destination and travel date. The admin panel allows for managing bookings and flight schedules.

### Key Features:
- **User Registration and Authentication**: Allows users to sign up, log in, and manage their accounts.
- **Flight Search**: Users can search for available flights based on destination, departure date, and return date.
- **Booking System**: Allows users to book flights and view their booking history.
- **Admin Panel**: Admin users can manage flight schedules, view all bookings, and cancel bookings.
- **User Dashboard**: Users can view, update, or cancel their flight bookings.

## Table of Contents
- [Installation](#installation)
- [Usage](#usage)
- [Technologies Used](#technologies-used)
- [Technical Overview](#technical-overview)
  - [Models](#models)
  - [Serializers](#serializers)
  - [Views/Viewsets](#viewsviewsets)
  - [Notable Design Decisions](#notable-design-decisions)
- [Contributing](#contributing)
- [License](#license)

## Installation

### Prerequisites
To run this project, you need to have the following installed on your machine:

- Python 3.x
- Django
- SQLite (default database)

### Steps to Set Up the Project Locally

1. Clone the repository:
    ```bash
    git clone https://github.com/PattyMbua/152569-airline-booking/
    cd airline_booking_system
    ```

2. Create a virtual environment (optional but recommended):
    ```bash
    python3 -m venv venv
    ```

3. Activate the virtual environment:
    - On Windows:
      ```bash
      .\venv\Scripts\activate
      ```
    - On macOS/Linux:
      ```bash
      source venv/bin/activate
      ```

4. Install the required dependencies:
    ```bash
    pip install -r requirements.txt
    ```

5. Run the database migrations:
    ```bash
    python manage.py migrate
    ```

6. Create a superuser (admin user) to access the Django admin panel:
    ```bash
    python manage.py createsuperuser
    ```

    Enter the requested details (username, email, password). **Alternatively**, you can use the following superuser credentials for quick access:

    - **Username**: `patty_k`
    - **Email**: `patk22@example.com`
    - **Password**: `123456`

7. Start the development server:
    ```bash
    python manage.py runserver
    ```

8. Open your browser and navigate to `http://127.0.0.1:8000` to access the application.
   - To access the admin panel, go to `http://127.0.0.1:8000/admin/` and log in with the superuser credentials.

## Usage

### User Features:
- **Register**: Create a new account by providing a username, email, and password.
- **Login**: Access the system with your registered username and password.
- **Search Flights**: After logging in, users can search for available flights based on their destination and travel dates.
- **Book Flights**: Select available flights and proceed to book.
- **Manage Bookings**: View your booking history, update, or cancel bookings.

### Admin Features:
- **Login**: Use the superuser credentials to access the Django admin panel.
- **Manage Flights**: Admins can add, edit, or delete flights from the system.
- **View Bookings**: Admins can see all bookings made by users and have the ability to cancel bookings.
- **Manage Users**: Admins can view and manage registered users.

## Technologies Used
- **Backend**: Django (Python)
- **Database**: SQLite (default database)
- **Frontend**: HTML, CSS, JavaScript
- **Version Control**: Git

## Technical Overview

### Models
- **User**: Represents the users of the system (both customers and admins). It includes fields such as username, email, and password.
- **Flight**: Represents a flight with details such as departure city, destination, departure time, return time, and price.
- **Booking**: Represents a booking made by a user. This model includes foreign keys to the `User` and `Flight` models, as well as additional booking details such as booking status and payment status.

### Serializers
- **UserSerializer**: Serializes the user data to be sent as JSON for user registration and login.
- **FlightSerializer**: Serializes the flight data for viewing available flights and managing flight schedules.
- **BookingSerializer**: Serializes the booking data for viewing and managing users' flight bookings.

### Views/Viewsets
- **UserViewSet**: Handles user registration, login, and profile management.
- **FlightViewSet**: Handles flight listing, search, and management by admins.
- **BookingViewSet**: Handles booking creation, viewing, updating, and cancellation.

### Notable Design Decisions
- **Database Choice**: We used SQLite as the default database for simplicity, but it can be replaced with a more robust solution like PostgreSQL or MySQL in production environments.
- **Django Rest Framework**: This project uses Django Rest Framework for API endpoints, making it easier to manage data and implement functionalities like user authentication, booking management, etc.
- **Template-based Frontend**: While the system is built with Django's template system for simplicity, it can be extended to a more dynamic frontend using frameworks like React or Vue.js if needed.

## Contributing

If you'd like to contribute to the project, follow these steps:

1. Fork the repository.
2. Create a new branch:
    ```bash
    git checkout -b feature-branch
    ```
3. Make your changes and commit them:
    ```bash
    git commit -m "Add new feature"
    ```
4. Push the changes to your fork:
    ```bash
    git push origin feature-branch
    ```
5. Open a pull request to merge your changes.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.
