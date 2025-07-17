from rest_framework import serializers
from .models import Flight, Passenger

class FlightSerializer(serializers.ModelSerializer):
    class Meta:
        model = Flight
        fields = '__all__'  # Serialize all fields

class PassengerSerializer(serializers.ModelSerializer):
    # Use PrimaryKeyRelatedField to accept a flight ID
    flight = serializers.PrimaryKeyRelatedField(queryset=Flight.objects.all())

    class Meta:
        model = Passenger
        fields = '__all__'

    def create(self, validated_data):
        # Directly use the validated flight instance
        return Passenger.objects.create(**validated_data)
