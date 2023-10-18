package com.airafrika.App.Providers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.airafrika.Core.environment;
import lombok.Getter;

/**
 * The Cloudinary class provides a centralized instance of the Cloudinary client
 * for interacting with the Cloudinary service.
 */
public class cloudinaryProvider {

    /**
     * -- GETTER --
     * Retrieves the Cloudinary client instance.
     */
    @Getter
    private static volatile Cloudinary cloudinary = null;

    private cloudinaryProvider() {
    }

    static {
        if (cloudinary == null) {
            synchronized (cloudinaryProvider.class) {
                if (cloudinary == null) {
                    cloudinary = new Cloudinary(
                            ObjectUtils.asMap(
                                    "cloud_name", System.getenv("CLOUDINARY_CLOUD_NAME"),
                                    "api_key", System.getenv("CLOUDINARY_API_KEY"),
                                    "api_secret", System.getenv("CLOUDINARY_API_SECRET")
                            )
                    );
                }
            }
        }
    }

}
