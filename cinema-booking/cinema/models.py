from django.db import models

# Movie Model
class Movie(models.Model):
    title = models.CharField(max_length=200)
    description = models.TextField()
    duration = models.PositiveIntegerField(help_text="Duration in minutes")
    release_date = models.DateField()

    def __str__(self):
        return self.title


# Showtime Model (Linked to Movie)
class Showtime(models.Model):
    movie = models.ForeignKey(Movie, on_delete=models.CASCADE, related_name='showtimes')
    show_time = models.DateTimeField()
    
    def __str__(self):
        return f"{self.movie.title} at {self.show_time}"


# Customer Model
class Customer(models.Model):
    first_name = models.CharField(max_length=100)
    last_name = models.CharField(max_length=100)
    email = models.EmailField(unique=True)

    def __str__(self):
        return f"{self.first_name} {self.last_name}"


# Seat Model
class Seat(models.Model):
    hall_name = models.CharField(max_length=100)
    seat_number = models.CharField(max_length=10)
    is_available = models.BooleanField(default=True)

    def __str__(self):
        return f"{self.hall_name} - {self.seat_number}"


# Booking Model (Linked to Customer, Showtime, and Seat)
class Booking(models.Model):
    customer = models.ForeignKey(Customer, on_delete=models.CASCADE, related_name='bookings')
    showtime = models.ForeignKey(Showtime, on_delete=models.CASCADE, related_name='bookings')
    seat = models.ForeignKey(Seat, on_delete=models.CASCADE, related_name='bookings')
    booking_date = models.DateTimeField(auto_now_add=True)
    total_price = models.DecimalField(max_digits=10, decimal_places=2)

    def __str__(self):
        return f"Booking by {self.customer} for {self.showtime.movie.title} on {self.showtime.show_time}"
