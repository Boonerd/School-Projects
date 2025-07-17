from django.urls import path, include
from rest_framework.routers import DefaultRouter
from . import views

# Create a router and register your viewsets with it
router = DefaultRouter()
router.register(r'flights', views.FlightViewSet)
router.register(r'passengers', views.PassengerViewSet)

# The API URLs are now determined automatically by the router
urlpatterns = [
    path('api/', include(router.urls)),  # Include the router URLs under 'api/'
]
