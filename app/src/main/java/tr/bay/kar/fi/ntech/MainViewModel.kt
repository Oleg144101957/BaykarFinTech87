package tr.bay.kar.fi.ntech

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import tr.bay.kar.fi.ntech.data.ErrorMessage
import tr.bay.kar.fi.ntech.domain.grey.PostErrorRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val postErrorApi: PostErrorRepository) :
    ViewModel() {

    fun sendError(errorMessage: ErrorMessage) {
        viewModelScope.launch {
            postErrorApi.postError(errorMessage)
        }
    }

}