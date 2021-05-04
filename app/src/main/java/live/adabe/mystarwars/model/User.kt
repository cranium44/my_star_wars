package live.adabe.mystarwars.model


import com.google.gson.annotations.SerializedName

data class User(
    var gender: String,
    var height: String,
    var name: String
)