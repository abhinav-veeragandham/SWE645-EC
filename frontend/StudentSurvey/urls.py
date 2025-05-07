# Team Members
# Abhinav Veeragandham - G01515455
# Pranav Vangavety - G01511443
# Charan Sri Sai Devalla - G01504177
# Bhogeswara Pathakamudi - G01507114
# Durga Shankar Kondaveeti - G01510533

# This file is used to define how URLs are mapped to views that handle logic for those URLs.
from django.contrib import admin
from django.urls import path, include

urlpatterns = [
    path('admin/', admin.site.urls),
    path('', include('survey.urls')),
]
