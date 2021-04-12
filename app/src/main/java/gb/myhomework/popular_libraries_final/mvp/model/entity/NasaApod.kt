package gb.myhomework.popular_libraries_final.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class NasaApod(
    @Expose val copyright: String,
//     The name of the copyright holder.
    @Expose val date: String,
//     Date of image. Included in response because of default values.
    @Expose val explanation: String,
//     The supplied text explanation of the image.
    @Expose val hdurl: String,
//     The URL for any high-resolution image for that day. Returned regardless of 'hd' param setting
//     but will be omitted in the response IF it does not exist originally at APOD.
    @Expose val mediaType: String,
//     The type of media (data) returned. May either be 'image' or 'video' depending on content.
    @Expose val serviceVersion: String,
//     The service version used.
    @Expose val title: String,
//     The title of the image.
    @Expose val url: String,
//     The URL of the APOD image or video of the day.

    // Дополнительные поля
//    @Expose val resource: String,
//      A dictionary describing the image_set or planet that the response illustrates,
//      completely determined by the structured endpoint.
//    @Expose val concepts: String,
//     The most relevant concepts within the text explanation. Only supplied if concept_tags is set to True.
//    @Expose val conceptTags: Boolean,
//     A boolean reflection of the supplied option. Included in response because of default values.
//    @Expose val thumbnailUrl: String
//    The URL of thumbnail of the video.
) : Parcelable