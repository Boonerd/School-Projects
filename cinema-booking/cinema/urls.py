from django.urls import path, include
from rest_framework.routers import DefaultRouter
from .views import MovieViewSet, ShowtimeViewSet, CustomerViewSet, SeatViewSet, BookingViewSet

router = DefaultRouter()
router.register(r'movies', MovieViewSet)
router.register(r'showtimes', ShowtimeViewSet)
router.register(r'customers', CustomerViewSet)
router.register(r'seats', SeatViewSet)
router.register(r'bookings', BookingViewSet)

urlpatterns = [
    path('api/', include(router.urls)),
]
