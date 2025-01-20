plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "twozo.io.home"
    compileSdk = 34

    defaultConfig {
        applicationId = "twozo.io.home"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        release {
            buildConfigField("String", "BASE_URL", "\"https://crm.twozo.io\"")
        }
        create("beta") {
            initWith(getByName("release"))
            buildConfigField("String", "BASE_URL", "\"https://beta-crm.twozo.io\"")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}