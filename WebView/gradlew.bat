<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:background="@drawable/gradientgreen"

    tools:context="www.vaaiibhav.me.studygurueng.Class4th.Mathematics4Activity">

    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical">
            <!--chapter(std) 5 math1   -->

            <TextView
                android:id="@+id/unitone"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginTop="10dp"
                android:background="@drawable/gradient_green"
                android:text="Part One"
                android:textAlignment="center"
                android:textColor="@android:color/black"
                
                android:textStyle="bold" />

            <Button
                android:id="@+id/ch4a1"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginTop="10dp"
                android:background="@drawable/rounded_yellow"
                android:text="Geometrical Figures"
                android:textColor="@android:color/black"
                
                android:textStyle="bold" />

            <Button
                android:id="@+id/ch4a2"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginTop="10dp"
                android:background="@drawable/rounded_yellow"
     