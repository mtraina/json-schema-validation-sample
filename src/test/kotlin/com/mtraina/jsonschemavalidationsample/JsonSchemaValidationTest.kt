package com.mtraina.jsonschemavalidationsample

import org.everit.json.schema.loader.SchemaLoader
import org.json.JSONObject
import org.json.JSONTokener
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
class JsonSchemaValidationTest {

    val book = "{\n" +
            "  \"isbn10\": \"0000000000\",\n" +
            "  \"title\": \"count of montecristo\",\n" +
            "  \"details\": {\n" +
            "    \"dimensions\": \"5.2 x 2.2 x 7.8 inches\",\n" +
            "    \"language\": \"english\"\n" +
            "  }\n" +
            "}"

    @Test
    fun shouldValidate() {
        javaClass.getResourceAsStream("/schemas/book-schema.json").use { inputStream ->
            val rawSchema = JSONObject(JSONTokener(inputStream))
            val schema = SchemaLoader.load(rawSchema)
            schema.validate(JSONObject(book)) // throws a ValidationException if this object is invalid
        }
    }

}
