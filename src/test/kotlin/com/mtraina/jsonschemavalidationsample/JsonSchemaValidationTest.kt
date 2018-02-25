package com.mtraina.jsonschemavalidationsample

import org.everit.json.schema.loader.SchemaLoader
import org.json.JSONObject
import org.json.JSONTokener
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
class JsonSchemaValidationTest {

    val book = javaClass.getResourceAsStream("/book.json").use { JSONObject(JSONTokener(it)) }

    @Test
    fun shouldValidate() {
        javaClass.getResourceAsStream("/schemas/book-schema.json").use { inputStream ->
            val rawSchema = JSONObject(JSONTokener(inputStream))
            val schema = SchemaLoader.load(rawSchema)
            schema.validate(book) // throws a ValidationException if this object is invalid
        }
    }

}
