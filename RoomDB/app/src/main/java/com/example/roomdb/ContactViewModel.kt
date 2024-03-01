package com.example.roomdb

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ContactViewModel(private val dao:ContactDao):ViewModel() {
    private val _state= MutableStateFlow(ContactState())
    private val _sortType=MutableStateFlow(SortType.FIRST_NAME)
    private val _contacts = _sortType
        .flatMapLatest { sortType->
            when(sortType) {
                SortType.FIRST_NAME->dao.getContactsOrderedByFirstName()
                SortType.LAST_NAME->dao.getContactsOrderedByLastName()
                SortType.PHONE_NUMBER->dao.getContactsOrderedByPhoneName()
            }
    }
        .stateIn(viewModelScope,SharingStarted.who;e)

    fun onEvent(event:ContactEvent)
    {
        when(event)
        {
            is ContactEvent.DeleteContact-> {
                viewModelScope.launch {
                    dao.deleteContact(event.contact)
                }
            }
             ContactEvent.HideDialog->{
                _state.update {
                    it.copy(
                        isAddingContact = false
                    )
                }
            }
            is ContactEvent.SaveContact->{

            }

            is ContactEvent.SetFirstName->{
                _state.update {
                    it.copy(firstName = event.firstName)
                }
            }
            is ContactEvent.SetLastName->{
                _state.update {
                    it.copy(lastName = event.lastName)
                }
            }

            is ContactEvent.phoneNumber->{
                _state.update {
                    it.copy(phoneNumber = event.phoneNumber)
                }
            }

            else -> {}
        }
    }
}