package com.kh.mycore.data.cache


/**
 * this class used for runtime state holder
 * this class is internal core class and most used only by Repository classes
 *
 */
internal class InMemoryCache {
    companion object{
        private val memoryCache = mutableMapOf<String,Any>()

        /**
         * add or update value in runtime memory cache
         *
         * @param key key for internal map used for hold objects
         * @param value value to cache in runtime memory
         */
        fun writeToCache(key:String , value:Any) { memoryCache+= key to value}

        /**
         * read value from runtime memory
         *
         * @param T Generic type that indicate returned class type and use to cast returned Any object to T
         * @param key use for return cached value from internal map
         * @return T an nullable object return from map if exist that key or null if dose not exist
         */
        fun <T> readFromCache(key: String):T? = memoryCache[key]?.let { it as T }
    }
}