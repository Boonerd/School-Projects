from django.contrib import admin
from .models import Movie, Showtime, Customer, Seat, Booking

admin.site.register(Movie)
admin.site.register(Showtime)
admin.site.register(Customer)
admin.site.register(Seat)
admin.site.register(Booking)
