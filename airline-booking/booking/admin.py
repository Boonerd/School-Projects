from django.contrib import admin
from .models import Flight, Passenger  # Import your models

# Register your models with the admin site
admin.site.register(Flight)
admin.site.register(Passenger)
