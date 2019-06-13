package com.nomensvyat.exchange.core.di

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ComponentManagerTest {

    lateinit var componentManager: ComponentManager

    @Before
    fun init() {
        componentManager = ComponentManager
        componentManager.clear()
    }

    @Test
    fun putTest() {
        componentManager.put(ComponentImpl)

        assertTrue(componentManager.has(Component::class))
        assertTrue(componentManager.has(ComponentChild1::class))
        assertTrue(componentManager.has(ComponentChild2::class))
        assertFalse(componentManager.has(ComponentChild1Child::class))
    }

    @Test
    fun removeSimpleTest() {
        componentManager.put(ComponentImpl)

        componentManager.remove(Component::class)

        assertFalse(componentManager.has(Component::class))
        assertFalse(componentManager.has(ComponentChild1::class))
        assertFalse(componentManager.has(ComponentChild2::class))
    }

    @Test
    fun removeComplexTest() {
        componentManager.put(ComponentImpl)
        componentManager.put(ComponentOtherImpl)

        componentManager.remove(Component::class)

        assertFalse(componentManager.has(Component::class))
        assertTrue(componentManager.has(ComponentOther::class))
        assertTrue(componentManager.has(ComponentChild1::class))
        assertTrue(componentManager.has(ComponentChild2::class))

        assertEquals(ComponentOtherImpl, componentManager.get(ComponentOther::class))
        assertEquals(ComponentOtherImpl, componentManager.get(ComponentChild1::class))
        assertEquals(ComponentOtherImpl, componentManager.get(ComponentChild2::class))
    }

    object ComponentImpl : Component
    object ComponentOtherImpl : ComponentOther
    interface Component : ComponentChild1, ComponentChild2
    interface ComponentOther : ComponentChild1, ComponentChild2
    interface ComponentChild1 : ComponentChild1Child
    interface ComponentChild1Child

    interface ComponentChild2
}