# Team Members
# Abhinav Veeragandham - G01515455
# Pranav Vangavety - G01511443
# Charan Sri Sai Devalla - G01504177
# Bhogeswara Pathakamudi - G01507114
# Durga Shankar Kondaveeti - G01510533

# This file is used to define how URLs are mapped to views that handle logic for those URLs.
from django.urls import path
from . import views

urlpatterns = [
    path('', views.welcome, name='welcome'),
    path('survey/', views.survey_form, name='survey_form'),
    path('surveys/', views.all_surveys, name='all_surveys'),
    path('edit/<int:id>/', views.edit_survey, name='edit_survey'),
    path('delete/<int:id>/', views.delete_survey, name='delete_survey'),
]
