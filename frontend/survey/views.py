# Team Members
# Abhinav Veeragandham - G01515455
# Pranav Vangavety - G01511443
# Charan Sri Sai Devalla - G01504177
# Bhogeswara Pathakamudi - G01507114
# Durga Shankar Kondaveeti - G01510533

# This file handles user input, form rendering and REST API communication.

from django.shortcuts import render, redirect
import requests
from django.contrib import messages

API_URL = "http://98.80.116.219:31001/api/surveys"

LIKED_OPTIONS = ["Campus", "Students", "Location", "Atmosphere"]
SOURCES = ["Friends", "Television", "Internet", "Other"]
RECOMMENDATIONS = ["Very Likely", "Likely", "Unlikely"]

# Welcome page
def welcome(request):
    return render(request, 'welcome.html')

# Display survey form
def survey_form(request):
    if request.method == 'POST':
        data = {
            "firstName": request.POST.get('firstName'),
            "lastName": request.POST.get('lastName'),
            "street": request.POST.get('street'),
            "city": request.POST.get('city'),
            "state": request.POST.get('state'),
            "zip": request.POST.get('zip'),
            "phone": request.POST.get('phone'),
            "email": request.POST.get('email'),
            "surveyDate": request.POST.get('surveyDate'),
            "likedMost": request.POST.getlist('likedMost'),
            "interestSource": request.POST.get('interestSource', ''),
            "recommendation": request.POST.get('recommendation', ''),
            "comments": request.POST.get('comments', '')
        }
        requests.post(API_URL, json=data)
        # return redirect('all_surveys')
        messages.success(request, "Form submitted successfully!")
        return redirect('survey_form')

    return render(request, 'survey_form.html', {
        'liked_options': LIKED_OPTIONS,
        'sources': SOURCES,
        'recommendation_options': RECOMMENDATIONS
    })

# View all surveys
def all_surveys(request):
    try:
        res = requests.get(API_URL)
        surveys = res.json()
    except requests.exceptions.ConnectionError:
        surveys = []
    return render(request, 'all_surveys.html', {'surveys': surveys})

# Edit a survey
from django.contrib import messages

def edit_survey(request, id):
    url = f"{API_URL}/{id}"
    if request.method == 'POST':
        data = {
            "firstName": request.POST.get('firstName'),
            "lastName": request.POST.get('lastName'),
            "street": request.POST.get('street'),
            "city": request.POST.get('city'),
            "state": request.POST.get('state'),
            "zip": request.POST.get('zip'),
            "phone": request.POST.get('phone'),
            "email": request.POST.get('email'),
            "surveyDate": request.POST.get('surveyDate'),
            "likedMost": request.POST.getlist('likedMost'),
            "interestSource": request.POST.get('interestSource', ''),
            "recommendation": request.POST.get('recommendation', ''),
            "comments": request.POST.get('comments', '')
        }
        requests.put(url, json=data)
        messages.success(request, "Form updated successfully!")
        return redirect('all_surveys')

    survey = requests.get(url).json()
    liked_selected = survey.get('likedMost', [])
    if isinstance(liked_selected, str):
        liked_selected = [item.strip() for item in liked_selected.split(',')]

    return render(request, 'edit_survey.html', {
        'survey': survey,
        'liked_options': LIKED_OPTIONS,
        'sources': SOURCES,
        'recommendation_options': RECOMMENDATIONS,
        'selected_liked': liked_selected
    })

# Delete a survey
def delete_survey(request, id):
    url = f"{API_URL}/{id}"
    requests.delete(url)
    return redirect('all_surveys')
