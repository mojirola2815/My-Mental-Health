# My Mental Health Program

import math
import random

# Define Functions

def mental_checkup():
    total_score = 0
    print("Please rate the following options from 0 - 10 (10 highest):")
    print("Stress Level ____")
    stress_level = int(input())
    total_score += stress_level
    print("Anxiety Level ____")
    anxiety_level = int(input())
    total_score += anxiety_level
    print("Depression Level ____")
    depression_level = int(input())
    total_score += depression_level
    print("Your total score is: ", total_score)

    if total_score <= 10:
        condition = "You are in perfect mental health"
    elif total_score > 10 and total_score <=20:
        condition = "You are experiencing minor stress and could use some time to relax"
    elif total_score > 20 and total_score <=30:
        condition = "You are suffering from moderate mental health issues, please seek help"
    else:
        condition = "You are suffering from severe mental health issues, please seek help immediately"
    
    print(condition)

def relaxation_routine():
    duration = int(input("How long do you want to relax for? (minutes)____"))
    exercises = int(input("How many relaxation exercises do you want to do?____"))
    print("Let's get into your relaxation routine:")
    for x in range(0, exercises):
        exercise_number = x + 1
        exercise = random.choice(['Deep Breathing', 'Stretching', 'Visualization', 'Journaling', 'Meditating'])
        print("Exercise ", exercise_number, ": ", exercise)
        time_exercise = math.ceil(duration/exercises)
        if time_exercise == 1:
            print("Time for this exercise: ", time_exercise, "minute")
        else:
            print("Time for this exercise: ", time_exercise, "minutes")
    print("Congratulations! You have completed your relaxation routine")

# Definitions for Menus

def main_menu():
    print("Main Menu:")
    print("1. Mental Checkup")
    print("2. Relaxation Routine")
    print("3. Quit")
    main_menu_choice = input("Choose an option____")
    if main_menu_choice == '1':
        mental_checkup()
    if main_menu_choice == '2':
        relaxation_routine()
    if main_menu_choice == '3':
        quit()

# Execute Program

print("Welcome to My Mental Health Program")
main_menu()