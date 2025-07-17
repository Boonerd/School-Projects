from rest_framework import viewsets
from .models import Flight, Passenger
from .serializers import FlightSerializer, PassengerSerializer
from django_filters.rest_framework import DjangoFilterBackend
from rest_framework import filters

class FlightViewSet(viewsets.ModelViewSet):
    queryset = Flight.objects.all()
    serializer_class = FlightSerializer

class PassengerViewSet(viewsets.ModelViewSet):
    queryset = Passenger.objects.all()
    serializer_class = PassengerSerializer
    filter_backends = (DjangoFilterBackend, filters.OrderingFilter)
    filterset_fields = ['flight']  # Allows filtering passengers by flight
    ordering_fields = ['first_name', 'last_name']  # Optional: Allows sorting by first_name or last_name
    ordering = ['first_name']  # Default ordering
