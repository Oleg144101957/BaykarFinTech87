package tr.ba.y.kar.fi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import tr.ba.y.kar.fi.data.ErrorMessage
import tr.ba.y.kar.fi.domain.grey.PostErrorRepository
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