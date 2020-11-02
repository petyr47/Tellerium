package com.aneke.peter.tellerium.update

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import coil.load
import com.aneke.peter.tellerium.R
import com.aneke.peter.tellerium.databinding.ActivityUpdateFarmerBinding
import com.kroegerama.imgpicker.BottomSheetImagePicker
import com.kroegerama.imgpicker.ButtonType
import kotlinx.android.synthetic.main.activity_update_farmer.*
import org.koin.android.ext.android.inject

class UpdateFarmerActivity : AppCompatActivity(), BottomSheetImagePicker.OnImagesSelectedListener {

    private val viewModel : UpdateViewModel by inject()
    private lateinit var binding : ActivityUpdateFarmerBinding

    private var id = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_farmer)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_update_farmer)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        id = intent.getIntExtra("id", 0)
        viewModel.fetchFarmer(id)

        back_btn.setOnClickListener {
            onBackPressed()
        }
        save.setOnClickListener {
            showConfirmationDialog()
        }

        edit_image.setOnClickListener {
            BottomSheetImagePicker.Builder(getString(R.string.file_provider))
                .cameraButton(ButtonType.Button)            //style of the camera link (Button in header, Image tile, None)
                .galleryButton(ButtonType.Button)           //style of the gallery link
                // size of the columns (will be changed a little to fit)
                .requestTag("single")                       //tag can be used if multiple pickers are used
                .show(supportFragmentManager)
        }


        viewModel.farmer.observe(this, { farmer ->
            val url = if (farmer.imageUpdated) farmer.newPassport else  viewModel.url
            passport.load(url)})
    }


    override fun onBackPressed() {
        showConfirmationDialog()
    }

    private fun showConfirmationDialog() {
        val builder = AlertDialog.Builder(this).apply {
            setTitle("Save Changes")
            setMessage("Do you want to save changes?")
            setPositiveButton("YES"){ dialog, _ ->
                viewModel.updateFarmer()
                dialog.dismiss()
                finish()
            }
            setNegativeButton("NO"){ dialog, _ ->
                dialog.dismiss()
                finish()
            }
        }

        if (!isFinishing) {
            val dialog = builder.create()
            dialog.show()
        }
    }

    override fun onImagesSelected(uris: List<Uri>, tag: String?) {
        val uri = uris.first()
        passport.load(uri)
        viewModel.imageChanged = true
        viewModel.imageUri = uri.toString()
    }
}