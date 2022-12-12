package com.paulo.waystoincrease.tips

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

/*
Reading state
Defer reading state until you need it
 */


data class Contact(
    val name: String,
    val id: Int,
) : Comparator<Contact> {
    override fun compare(p0: Contact?, p1: Contact?): Int {
        return 0 // not implemented
    }
}

val contactsComparate = Contact("PAULO", 0)

val listOfContacts = listOf(
    Contact("PAULO", 0),
    Contact("MALU", 1),
    Contact("BRUNA", 2),
    Contact("RENATA", 3)
)

@Composable
fun Tip6(isOptimized: Boolean = false) {

    if (isOptimized)
        RightExample(
            contacts = listOfContacts,
            comparator = contactsComparate
        )
    else
        WrongExample(listOfContacts, contactsComparate)
}


//DON'T DO THIS
@Composable
fun WrongExample(
    contacts: List<Contact>,
    comparator: Comparator<Contact>,
    modifier: Modifier = Modifier
) {
    val listState = rememberLazyListState()

    LazyColumn(modifier, state = listState) {
        //DON'T DO THIS
        items(contacts.sortedWith(comparator)) { contact ->
            // do something
        }
    }
    val showButton = listState.firstVisibleItemIndex > 0
    AnimatedVisibility(visible = showButton) {
        //SCROLL TO TOP BUTTON
    }

}

// DO THIS
// remember{} Use to only run expensive operations once
//PUT A KEY LazyList Key
//define a key on your LazyList Items
//DERIVEDSTATEOF{}
//Use to buffer the rate of change
@Composable
fun RightExample(
    contacts: List<Contact>,
    comparator: Comparator<Contact>,
    modifier: Modifier = Modifier
) {
    val listState = rememberLazyListState()

    val sortedContacts = remember(contacts, comparator) {
        contacts.sortedWith(comparator)
    }


    val showButton by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 0
        }
    }
    LazyColumn(modifier, state = listState) {
        //Use the key parameter to provide a unique
        //key for each item
        items(sortedContacts, key = { it.id }) { contact ->
            // do something
        }
    }
    AnimatedVisibility(visible = showButton) {
        //SHOW THE BUTTON
    }
}
/*
ANOTHER EXAMPLE

    val contacts by viewModel.contacts.observeAsState()

    //DON'T
    val contactCount = remember{
    derivedStateOf{
    contacts.size


    //DO
    val contactCount = contacts.size
 */