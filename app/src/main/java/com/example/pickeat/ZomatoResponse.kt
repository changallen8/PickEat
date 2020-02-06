package com.example.pickeat

data class ZomatoResponse(
    val restaurants: List<Restaurant>,
    val results_found: String,
    val results_shown: String,
    val results_start: String
)

data class Restaurant(
    val all_reviews: List<AllReview>,
    val all_reviews_count: String,
    val average_cost_for_two: String,
    val cuisines: String,
    val currency: String,
    val deeplink: String,
    val events_url: String,
    val featured_image: String,
    val has_online_delivery: String,
    val has_table_booking: String,
    val id: String,
    val is_delivering_now: String,
    val location: Location,
    val menu_url: String,
    val name: String,
    val phone_numbers: String,
    val photo_count: String,
    val photos: List<Photo>,
    val photos_url: String,
    val price_range: String,
    val thumb: String,
    val url: String,
    val user_rating: UserRating
)

data class AllReview(
    val comments_count: String,
    val id: String,
    val likes: String,
    val rating: String,
    val rating_color: String,
    val rating_text: String,
    val review_text: String,
    val review_time_friendly: String,
    val timestamp: String,
    val user: User
)

data class User(
    val foodie_color: String,
    val foodie_level: String,
    val foodie_level_num: String,
    val name: String,
    val profile_deeplink: String,
    val profile_image: String,
    val profile_url: String,
    val zomato_handle: String
)

data class Location(
    val address: String,
    val city: String,
    val country_id: String,
    val latitude: String,
    val locality: String,
    val longitude: String,
    val zipcode: String
)

data class Photo(
    val caption: String,
    val comments_count: String,
    val friendly_time: String,
    val height: String,
    val id: String,
    val likes_count: String,
    val res_id: String,
    val thumb_url: String,
    val timestamp: String,
    val url: String,
    val user: UserX,
    val width: String
)

data class UserX(
    val foodie_color: String,
    val foodie_level: String,
    val foodie_level_num: String,
    val name: String,
    val profile_deeplink: String,
    val profile_image: String,
    val profile_url: String,
    val zomato_handle: String
)

data class UserRating(
    val aggregate_rating: String,
    val rating_color: String,
    val rating_text: String,
    val votes: String
)