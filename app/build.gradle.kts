plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)

    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")

    id("androidx.navigation.safeargs.kotlin")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.loveapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.loveapp"
        minSdk = 27
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            buildConfigField("String","API_KEY","\"9ab403d45bmsh5e7a6133bc1029dp102882jsnd6462fe926c0\"")
            buildConfigField("String","HOST","\"https://love-calculator.p.rapidapi.com/getPercentage?sname=Alice&fname=John\"")
            buildConfigField("String","BASE_URL","\"love-calculator.p.rapidapi.com\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    defaultConfig{
        applicationId = "com.example.loveapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        //constants
        buildConfigField("String","API_KEY","\"9ab403d45bmsh5e7a6133bc1029dp102882jsnd6462fe926c0\"")
        buildConfigField("String","HOST","\"https://love-calculator.p.rapidapi.com/getPercentage?sname=Alice&fname=John\"")
        buildConfigField("String","BASE_URL","\"love-calculator.p.rapidapi.com\"")
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //navigation
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    //ui
    implementation(libs.androidx.cardview)

    //retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    //room
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)

    //DotsIndicator
    implementation(libs.dotsindicator)

    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-android-compiler:2.51.1")
}

kapt {
    correctErrorTypes = true
}