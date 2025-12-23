import React from 'react'
import './page1.css'
import { useNavigate } from 'react-router-dom'
function Page1() {
  let navigate = useNavigate()
  return (
    <div className='page1'>
      <img src="src/assets/logo.png" alt="" />
      <h2>Create or sign in to your account</h2>
      <p>A beacon for smarter business decisions</p>
      <div>
        <button onClick={() => navigate('/sign-in')} >Sign in</button>
        <button>Sign up</button>
      </div>
    </div>
  )
}

export default Page1